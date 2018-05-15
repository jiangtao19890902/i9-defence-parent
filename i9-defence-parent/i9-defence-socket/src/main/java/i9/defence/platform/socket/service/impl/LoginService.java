package i9.defence.platform.socket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import i9.defence.platform.mq.libraries.destination.ActiveMQQueueEnum;
import i9.defence.platform.mq.libraries.producer.ActiveMQProducerService;
import i9.defence.platform.netty.libraries.req.LoginReqMessage;
import i9.defence.platform.socket.context.ChannelPacker;
import i9.defence.platform.socket.netty.Message;
import i9.defence.platform.socket.service.ICoreService;

@Service
public class LoginService implements ICoreService {

    @Override
    public void doPost(Message message, ChannelPacker channelPacker) {
        LoginReqMessage loginReqMessage = (LoginReqMessage) message.getMessageDecodeConvert();
        loginReqMessage.showInfo();
        channelPacker.saveLoginInfo(loginReqMessage);
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("channelId", channelPacker.getChannelId());
        jsonObject.put("systemId", channelPacker.systemId);
        jsonObject.put("loop", channelPacker.loop);
        jsonObject.put("deviceAddress", channelPacker.deviceAddress);
        activeMQProducerService.sendMessage(ActiveMQQueueEnum.I9_CONNECT, jsonObject.toJSONString());
    }
    
    @Autowired
    private ActiveMQProducerService activeMQProducerService;
}
