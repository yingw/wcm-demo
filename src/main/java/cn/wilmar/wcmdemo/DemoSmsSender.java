package cn.wilmar.wcmdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Component
public class DemoSmsSender {

    @Autowired
    RestTemplate template;

    @Value("${info.sp_account}")
    private String sp_account;
    @Value("${info.sp_password}")
    private String sp_password;
    @Value("${info.sp_extno}")
    private String sp_extno;
    @Value("${info.sp_url}")
    private String sp_url;

    public void sendSms(String phoneNumber, String msg) {
        System.out.println("发送 msg = " + msg);
        Map<String, String> params = new HashMap<>();
        params.put("action", "send");
        params.put("account", sp_account);
        params.put("password", sp_password);
        params.put("extno", sp_extno);
        params.put("mobile", phoneNumber);
        params.put("content", "【益海嘉里】" + msg);
        String returnVal = template.getForObject(sp_url, String.class, params);
        System.out.println("平台返回：" + returnVal);
    }
}