package com.xxy.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxy.api.entity.QueryDto;
import com.xxy.api.utils.Page;
import com.xxy.api.utils.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
public class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ModelAttribute
    public void index(HttpServletRequest request, ModelMap model)
    {

    }

    @SuppressWarnings("rawtypes")
    public QueryDto getParamsAsDto(HttpServletRequest request)
    {
        QueryDto dto=new QueryDto();
        Page pageParameter=new Page();
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        JSONObject jsonObject= WebUtils.getRequestPayload(request);
//        hashMap.put("user_openid", TokenUtils.getOpenidByToken(jsonObject.getString("token")));
//        hashMap.put("start", jsonObject.getString("start"));
//        hashMap.put("length", jsonObject.getString("length"));
        dto.setQueryCondition(hashMap);
        if (StringUtils.isNotEmpty((String) hashMap.get("start"))) {
            //每页显示多少条
            int end = Integer.parseInt((String) hashMap.get("length"));
            int start = 1;
            if (isNumber((String) hashMap.get("start"))) {
                //当前页数
                start = Integer.parseInt((String) hashMap.get("start"));
            }
            pageParameter.setCurrentPage(start);
            pageParameter.setPageSize(end);
        }
        dto.setPage(pageParameter);
        return dto;
    }

    /*
     * 后台获取分页参数
     */
    @SuppressWarnings("rawtypes")
    public QueryDto getAdminParamsAsDto(HttpServletRequest request)
    {
        QueryDto dto=new QueryDto();
        Page pageParameter = new Page();
        JSONObject jsonObject = WebUtils.getRequestPayload(request);
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            dto.getQueryCondition().put(entry.getKey(), entry.getValue());
        }
        if (StringUtils.isNotEmpty(dto.getAsString("page"))) {
            //每页显示多少条
            int end = Integer.parseInt(dto.getAsString("per_page"));
            int start = 1;
            if (isNumber(dto.getAsString("page"))) {
                //当前页数
                start = Integer.parseInt(dto.getAsString("page"));
            }
            pageParameter.setCurrentPage(start);
            pageParameter.setPageSize(end);
        }
        dto.setPage(pageParameter);
        return dto;
    }

    /**
     * 是否数字
     */
    private static final boolean isNumber(Object object) {
        //str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Pattern pattern = Pattern.compile("\\d+(.\\d+)?$");
        return pattern.matcher(object.toString()).matches();
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code
     * @return
     */
    String autoGenericCode(String code, int num) {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0
        // num 代表长度为4
        // d 代表参数为正数型
        result = String.format("%0" + num + "d", Integer.parseInt(code) + 1);

        return result;
    }


}
