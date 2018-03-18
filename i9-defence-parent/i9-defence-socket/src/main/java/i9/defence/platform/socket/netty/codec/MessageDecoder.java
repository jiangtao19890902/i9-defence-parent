package i9.defence.platform.socket.netty.codec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import i9.defence.platform.netty.libraries.EncryptUtils;
import i9.defence.platform.netty.libraries.MessageDecodeConvert;
import i9.defence.platform.netty.libraries.req.HeartbeatReqMessage;
import i9.defence.platform.netty.libraries.req.LoginReqMessage;
import i9.defence.platform.netty.libraries.req.UpStreamReqMessage;
import i9.defence.platform.socket.netty.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {

    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> list) throws Exception {
        // 如果包体小于起始符 + 版本号 + 消息类型 + 消息索引，表示不为完整包
        if (buf.readableBytes() < 1 + 1 + 1 + 4) {
            return;
        }
        buf.markReaderIndex();

        byte start = buf.readByte();    // 读取起始符
        byte version = buf.readByte();  // 读取版本号
        byte type = buf.readByte();     // 读取消息类型
        int index = buf.readInt();      // 读取消息索引

        MessageDecodeConvert messageDecodeConvert = null;
        if (type == 0x00) {
            messageDecodeConvert = new LoginReqMessage();
        } else if (type == -1) {
            messageDecodeConvert = new HeartbeatReqMessage();
        } else {
            messageDecodeConvert = new UpStreamReqMessage();
        }
        boolean canReset = messageDecodeConvert.decode(buf);
        if (canReset) {
            buf.resetReaderIndex();
            return;
        }
        // 读取消息体内容
        byte[] dst = messageDecodeConvert.getByteArray();
        // 如果包体小于检验和 + 结束符，表示不为完整包
        if (buf.readableBytes() < 1 + 1) {
            buf.resetReaderIndex();
            return;
        }
        byte sumcheck = buf.readByte(); // 读取校验和
        byte end = buf.readByte();      // 读取结束符
        
        logger.info(
                "解码, 起始符 : {}, 协议版本号 : {}, 消息类型 : {}, 消息索引 : {}, data : {}, 校验和 : {}, 结束符 : {}",
                String.format("%02X", start),
                String.format("%02X", version),
                String.format("%02X", type),
                index,
                EncryptUtils.bytesToHexString(dst),
                String.format("%02X", sumcheck),
                String.format("%02X", end));

        Message message = new Message();
        message.setType(type);
        message.setIndex(index);
        message.setMessageDecodeConvert(messageDecodeConvert);
        list.add(message);
    }
}
