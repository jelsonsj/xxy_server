package com.xxy.api.service;

import com.xxy.api.entity.AdminPermission;

import java.util.List;

public interface IPermissionService {

    /*
     * 获取菜单列表
     * type 0 全部 1为一级目录 2为2级菜单 3为3级功能按钮
    */
    public List<AdminPermission> findAdminPermissionList(int type);

    /*
     * 增加菜单
     */
    public void addAdminPermission(AdminPermission adminPermissionDto);

    /*
     * 更新菜单
     */
    public void updateAdminPermission(AdminPermission adminPermissionDto);

    /*
     * 删除菜单
     */
    public void deleteAdminPermission(int[] ids);

    /*
     * 获取单个菜单信息
     */
    public AdminPermission findAdminPermissionById(int id);


}
