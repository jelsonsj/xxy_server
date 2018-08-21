package com.xxy.api.service;

import com.xxy.api.entity.AdminUser;
import com.xxy.api.entity.QueryDto;

import java.util.List;

public interface IAdminService {

    /*
     * 后台登录
     */
    public AdminUser login(AdminUser adminUser);
    /*
     * 获取单个管理员用户
     */
    public AdminUser findAdminUserById(Long id);
    /*
     * 获取管理员列表
     */
    public List<AdminUser> findAdminUserList(QueryDto dto);
    /*
     * 添加管理员
     */
    public Boolean addAdminUser(AdminUser adminUser);
    /*
     * 修改管理员
     */
    public Boolean updateAdminUser(AdminUser adminUser);
    /*
     * 删除管理员
     */
    public Boolean deleteAdminUser(int[] ids);


}
