package i9.defence.platform.socket.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String msg) {
        logger.info("发送MQ数据, text : {}, destination :{}", msg, destination);
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        };
        jmsTemplate.send(destination, messageCreator);
    }
    
    @Resource(name = "destination")
    private Destination destination;

    public void sendMessage(final String msg) {
        this.sendMessage(destination, msg);
    }
}
