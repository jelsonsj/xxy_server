package com.xxy.api.controller.backend;

import com.xxy.api.config.ApiBackendConfig;
import com.xxy.api.controller.BaseController;
import com.xxy.api.entity.AdminUser;
import com.xxy.api.entity.QueryDto;
import com.xxy.api.service.IAdminService;
import com.xxy.api.utils.Helper;
import com.xxy.api.utils.Page;
import com.xxy.api.utils.Result;
import com.xxy.api.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "管理员")
@RestController
public class AdminController extends BaseController {

    @Autowired
    private IAdminService adminService;

    /*
     * 登录接口
     */

    @ApiOperation(value = "后台登录", notes = "")
    @RequestMapping(value= ApiBackendConfig.adminLogin,method = RequestMethod.POST)
    public Result<AdminUser> login(@RequestParam String username,@RequestParam String password)
    {
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

    @ApiOperation(value="管理员列表",notes = "")
    @RequestMapping(value= ApiBackendConfig.adminList,method = RequestMethod.GET)
    public Result<List<AdminUser>> adminList()
    {
        QueryDto dto=new QueryDto();
        Page page=new Page();
        dto.setPage(page);
        List<AdminUser> lst=adminService.findAdminUserList(dto);
        return ResultUtils.success(1,lst);
    }


    @ApiOperation(value="管理员详情",notes="")
    @RequestMapping(value=ApiBackendConfig.adminFind,method = RequestMethod.GET)
    public Result<AdminUser> findAdmin(@PathVariable Long id)
    {
        AdminUser user=adminService.findAdminUserById(id);
        return ResultUtils.success(1,user);
    }

    @ApiOperation(value = "创建管理员",notes = "")
    @RequestMapping(value=ApiBackendConfig.adminCreate,method = RequestMethod.POST)
    public Result createAdmin(@RequestBody @ApiParam(name="管理员",value="管理员对象") AdminUser user)
    {
        String salt=Helper.randomSalt();
        String password=Helper.md5(salt+"_"+Helper.md5(user.getPassword()));
        user.setSalt(Helper.randomSalt());
        user.setPassword(password);
        user.setLocked(0);
        user.setIs_super(0);
        boolean result=adminService.addAdminUser(user);
        if(result) {
            return ResultUtils.success();
        }
        else
        {
            return ResultUtils.error(0,"创建失败");
        }
    }

    @ApiOperation(value="修改管理员")
    @RequestMapping(value=ApiBackendConfig.adminUpdate,method = RequestMethod.PUT)
    public Result updateAdmin(@PathVariable Long id,@RequestBody @ApiParam(name="管理员",value="管理员对象")AdminUser user)
    {
        user.setUser_id(id);
        boolean result=adminService.updateAdminUser(user);
        return result?ResultUtils.success():ResultUtils.error(0,"更新失败");
    }


    @ApiOperation(value="删除管理员")
    @RequestMapping(value=ApiBackendConfig.adminDelete,method = RequestMethod.DELETE)
    public Result deleteAdmin(@PathVariable String ids)
    {
        String[] temp=ids.split(",");
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            if(!StringUtils.isEmpty(temp[i]))
            {
                result[i]=Integer.parseInt(temp[i]);
            }
        }
        boolean ret=adminService.deleteAdminUser(result);
        return ret?ResultUtils.success():ResultUtils.error(0,"更新失败");
    }

}
