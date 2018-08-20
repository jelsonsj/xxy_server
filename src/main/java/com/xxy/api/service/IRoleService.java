package com.xxy.api.service;

import com.xxy.api.entity.AdminRole;

import java.util.List;

public interface IRoleService {

    /*
     * 获取角色列表
     */
    public List<AdminRole> findAdminRole();

    /*
     * 增加角色
     */
    public void addAdminRole(AdminRole adminRoleDto);

    /*
     * 更新角色
     */
    public void updateAdminRole(AdminRole adminRoleDto);

    /*
     * 删除角色
     */
    public void deleteAdminRole(int[] ids);

    /*
     * 获取单个角色信息
     */
    public AdminRole findAdminRoleById(int id);

    /*
     * 分配角色权限
     */
    public void assignPermissions(int[] ids);
}
