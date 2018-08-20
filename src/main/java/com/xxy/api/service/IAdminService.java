package com.xxy.api.service;

import com.xxy.api.entity.AdminUser;

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
    public List<AdminUser> findAdminUserList();
    /*
     * 添加管理员
     */
    public void addAdminUser(AdminUser adminUser);
    /*
     * 修改管理员
     */
    public void updateAdminUser(AdminUser adminUser);
    /*
     * 删除管理员
     */
    public void deleteAdminUser(int[] ids);

    /*
     * 分配管理员角色
     */
    public void assignRoles(int admin_user_id,int[] role_ids);
}
