package com.xxy.api.utils;

public class TokenUtils {

    /**
     * 解析token获取openid
     *
     * @param token
     * @return
     */
    public static String getOpenidByToken(String token) {
        String openid = AESEnDecoder.decrypt(token);
        return openid;
    }

    /**
     * 生成token
     *
     * @param openid
     * @return
     */
    public static String createToken(String openid) {
        return AESEnDecoder.encrypt(openid);
    }

    public static void main(String[] args) {
        System.out.println(createToken("osAn15RmSptOPKRr1udb9XwhMT24"));
    }
}
