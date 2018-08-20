package com.xxy.api.utils;


/**
 * 常量配置
 */
public enum Constants {

    /**
     * 项目全局key,主要用于加密
     */
    APPLICATION_KEY("ZWK"),
    /**
     * session名称
     */
    DEFULT_LOGIN_SESSION("loginuser"),
    /**
     * 默认密码
     */
    DEFULT_PASSWORD("123456"),
    /**
     * 小程序appid
     */
    MINI_APP_ID("wxa474c1064f9452b7"),
    /**
     * 小程序APPSECRET
     */
    MINI_APPSECRET("0a5fa2d0efc1ce848d0a9d67bca52628"),
    /**
     * 发送模板地址
     */
    TEMPLATE_URL("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send"),
    /**
     * 抽奖结果模板id
     */
    TEMPLATE_LOTTERY_ID("cLHV34KifXMPsEtBBd8KYSF2Zq9ttj80pIcREwvj7Do");


    private final String value;

    private Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
