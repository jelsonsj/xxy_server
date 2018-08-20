package com.xxy.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxy.api.config.BodyReaderHttpServletRequestWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WebUtils {
    /**
     * 环境
     */
    @Value("${spring.profiles.active}")
    private String active_str;


    public static JSONObject getRequestPayload(HttpServletRequest request) {
        String body = new BodyReaderHttpServletRequestWrapper(request).getBodyString(request);
        JSONObject jsonObject = JSON.parseObject(body);
        return jsonObject;
    }

    static String getBody(HttpServletRequest request) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Map map = request.getParameterMap();
        Iterator keyIterator = (Iterator) map.keySet().iterator();
        String key, value = null;
        while (keyIterator.hasNext()) {
            key = (String) keyIterator.next();
            value = ((String[]) (map.get(key)))[0];
            if (!StringUtils.isEmpty(value) && value.equals("undefined")) {
                value = "";
            }
            hashMap.put(key, value.trim());
        }
        return JSON.toJSONString(hashMap);
    }


}
