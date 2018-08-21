package com.xxy.api.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Helper {

    /*
     * MD5加密
     * @param  source原密码
     */
    public static String md5(String source)
    {
        String md5Str=new String();
        try
        {
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte b[]=md.digest();
            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            md5Str = buf.toString().toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  md5Str;
    }

    /*
     * 生成随机字符串
     * @parm  length  字符串长度
     * @type  0默认数字 1为字母 2为字幕加数字
     */
    public static String getRandomChar(Integer length,Integer type)
    {
        char[] onlyNumber={'0','1','2','3','4','5','6','7','8','9'};
        char[] onlyChar={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] mix={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if(type==0)
            {
                buffer.append(onlyNumber[random.nextInt(10)]);
            }
            else if(type==1)
            {
                buffer.append(onlyChar[random.nextInt(26)]);
            }
            else
            {
                buffer.append(mix[random.nextInt(36)]);
            }
        }
        return buffer.toString();
    }

    /*
     * 默认生成6位数字的短信验证码
     */
    public static String randomSms()
    {
        return getRandomChar(6,0);
    }

    /*
     * 默认生成4位字母的加密盐
     */
    public static String randomSalt()
    {
        return getRandomChar(4,1);
    }

    //获取当前时间
    public static String getCurrentTime()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }




}
