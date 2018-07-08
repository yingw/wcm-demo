package cn.wilmar.wcmdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@DirtiesContext
public class DemoSmsSenderTest {

    private static final String PHONE_NUM = "18918558295";
    private static final String MSG_CONTENT = "你好啊，国伟！";

    @Autowired
    DemoSmsSender sender;

    @Test
    public void sendSms() {
        sender.sendSms(PHONE_NUM, MSG_CONTENT);
    }
}
