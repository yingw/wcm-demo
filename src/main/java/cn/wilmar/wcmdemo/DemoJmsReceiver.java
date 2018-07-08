package cn.wilmar.wcmdemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Component
public class DemoJmsReceiver {
    @Autowired
    DemoSmsSender sender;


    @JmsListener(destination = DemoJmsConfig.DEMO_QUEUE)
    public void receiveQueue(String msg) {
        JSONArray jsonArray = JSONArray.parseArray(msg);
        Arrays.stream(jsonArray.toArray(new JSONObject[0])).forEach(
                obj -> sender.sendSms(obj.getString("telno"), obj.getString("body"))
        );
    }
}
