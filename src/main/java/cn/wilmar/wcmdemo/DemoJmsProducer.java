package cn.wilmar.wcmdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Component
public class DemoJmsProducer {

    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;

    public void sendMessage(String msg) {
        this.template.convertAndSend(this.queue, msg);
    }
}