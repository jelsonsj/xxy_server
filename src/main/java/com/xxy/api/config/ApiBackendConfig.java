package com.xxy.api.config;

public interface ApiBackendConfig {


    String prefix="backend/v1/";

    String adminLogin=prefix+"login";  //后台登录

    //----------------------管理员管理--------------
    String adminList=prefix+"admins"; //管理员列表 GET
    String adminFind=prefix+"admins/{id}"; //单个管理员信息  GET
    String adminCreate=prefix+"admins"; //管理员创建 POST
    String adminUpdate=prefix+"admins/{id}"; //管理员更新  PUT
    String adminDelete=prefix+"admins/{ids}";  //管理员   DELETE
    String adminAssign=prefix+"admins/{id}/role/create";  // POST

    //---------------------角色管理
    String  roleList=prefix+"roles";   //角色列表GET
    String  roleFind=prefix+"roles/{id}";    //查找单个角色GET
    String  roleCreate=prefix+"roles"; //角色新建POST
    String  roleUpdate=prefix+"roles/{id}"; //角色编辑 PUT
    String  roleDelete=prefix+"roles/{ids}"; //删除角色DELETE
    String  roleAssign=prefix+"roles/{id}/permission/create"; //角色分配权限

    //---------------------权限管理
    String permissionList=prefix+"permissions"; //权限列表GET
    String permissionFind=prefix+"permissions/{id}"; //获取单个权限信息 GET
    String permissionCreate=prefix+"permissions"; //创建权限菜单POST
    String permissionUpdate=prefix+"permissions/{id}";//修改权限菜单PUT
    String permissionDelete=prefix+"permissions/{ids}";//删除权限菜单DELETE

}
