package cn.wilmar.wcmdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DemoJmsProducerTest {

    @Autowired
    DemoJmsProducer producer;

    @Test
    public void sendMessage() {
        this.producer.sendMessage("[\n" +
                "  {\n" +
                "    \"sys\": \"NCP\",\n" +
                "    \"key\": \"QWEASD123\",\n" +
                "    \"type\": \"2\",\n" +
                "    \"factoryName\": \"北京\",\n" +
                "    \"telno\": \"18726328826\",\n" +
                "    \"pernr\": \"\",\n" +
                "    \"subject\": \"mysubject\",\n" +
                "    \"body\": \"您好，测试，入场单RC1020000380步骤 入场登记 保存成功！下一步为 过首磅短信测试\",\n" +
                "    \"aux\": \"020910\"\n" +
                "  }\n" +
                "]");
    }
}