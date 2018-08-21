package com.xxy.api.mapper;

import com.xxy.api.entity.AdminUser;
import com.xxy.api.entity.QueryDto;

import java.util.List;

public interface AdminUserMapper {

    public AdminUser login(AdminUser adminUser);
    public AdminUser findAdminUserById(Long id);
    public List<AdminUser> findAdminUserList(QueryDto dto);
    public Long addAdminUser(AdminUser adminUser);
    public Long updateAdminUser(AdminUser adminUser);
    public Long deleteAdminUser(int[] ids);
}
