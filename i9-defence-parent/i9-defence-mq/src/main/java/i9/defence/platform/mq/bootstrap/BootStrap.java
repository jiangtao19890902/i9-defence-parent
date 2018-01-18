package i9.defence.platform.mq.bootstrap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import i9.defence.platform.mq.pool.BusinessPool;
import i9.defence.platform.mq.utils.SpringBeanService;

@SuppressWarnings("serial")
public class BootStrap extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("消息队列服务器已启动");
        BusinessPool businessPool = SpringBeanService.getBean(BusinessPool.class);
        businessPool.startTask();
    }
}
