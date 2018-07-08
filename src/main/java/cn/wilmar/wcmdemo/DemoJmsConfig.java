package cn.wilmar.wcmdemo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Component
public class DemoJmsConfig {
    public static final String DEMO_QUEUE = "yinguowei";

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(DEMO_QUEUE);
    }
}