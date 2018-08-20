package com.xxy.api.utils;

import com.github.pagehelper.Page;

public class ResultUtils {

    public static Result success(Integer code,Object object){
        Result result=new Result();
        if(null==code){
            result.setCode(200);
        }else
        {
            result.setCode(code);
        }
        result.setMessage("成功");
        if(object instanceof Page)
        {
            Page page=(Page) object;
            com.xxy.api.utils.Page result_page=new com.xxy.api.utils.Page();
            result_page.setCurrentPage(page.getPageNum());
            result_page.setPageSize(page.getPageSize());
            result_page.setCount(page.getTotal());
            result_page.setObject(page.getResult());
            result_page.setTotalPage(page.getPages());
            result_page.setTotal(page.getTotal());
            result.setData(result_page);
        }
        else
        {
            result.setData(object);
        }
        return result;
    }

    public static Result success()
    {
        return success(null,null);
    }

    public static Result success(Object object)
    {
        return success(null,object);
    }

    /*
     * 错误返回
     */
    public static Result error(Integer code,String message)
    {
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
