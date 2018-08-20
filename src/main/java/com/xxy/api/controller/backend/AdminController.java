package com.xxy.api.controller.backend;

import com.alibaba.fastjson.JSONObject;
import com.xxy.api.controller.BaseController;
import com.xxy.api.entity.AdminUser;
import com.xxy.api.service.IAdminService;
import com.xxy.api.utils.Result;
import com.xxy.api.utils.ResultUtils;
import com.xxy.api.utils.TokenUtils;
import com.xxy.api.utils.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(description = "管理员")
@RestController
@RequestMapping("/backend/")
public class AdminController extends BaseController {

    @Autowired
    private IAdminService adminService;

    /*
     * 登录接口
     */

    @ApiOperation(value = "后台登录", notes = "正常响应返回code=200,其他返回非200")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "body",name = "password", value = "密码", required = true),
    })
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Result<AdminUser> login(HttpServletRequest request)
    {
        JSONObject jsonObject= WebUtils.getRequestPayload(request);
        String username=jsonObject.getString("username");
        String password=jsonObject.getString("password");
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password))
        {
            AdminUser adminUser=AdminUser.builder().username(username).password(password).build();
            AdminUser login_admin=adminService.login(adminUser);
            if(null!=login_admin)
            {
                String token=CreateToken();
                login_admin.setToken(token);
                return ResultUtils.success(1,login_admin);
            }
            else
            {
                return ResultUtils.error(0,"用户名或密码错误");
            }
        }
        else
        {
            return ResultUtils.error(0,"用户名或密码为空");
        }

    }


}
