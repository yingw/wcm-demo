package cn.wilmar.wcmdemo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Data
@ToString
public class AnalyzeNCPJson implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sys;
    private String key;
    private String type;
    private String email;
    private String telno;// 手机号码
    private String pernr;
    private String subject;
    private String body;// 发送的内容
    private String aux;
    private String factoryName;//工厂编号

}