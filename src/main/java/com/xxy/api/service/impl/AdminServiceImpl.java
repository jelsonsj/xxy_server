package com.xxy.api.service.impl;

import com.xxy.api.entity.AdminUser;
import com.xxy.api.mapper.AdminUserMapper;
import com.xxy.api.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {


    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(AdminUser adminUser) {
        return adminUserMapper.login(adminUser);
    }

//    @Override
//    public AdminUser findAdminUserById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<AdminUser> findAdminUserList() {
//        return null;
//    }
//
//    @Override
//    public void addAdminUser(AdminUser adminUser) {
//
//    }
//
//    @Override
//    public void updateAdminUser(AdminUser adminUser) {
//
//    }
//
//    @Override
//    public void deleteAdminUser(int[] ids) {
//
//    }
//
//    @Override
//    public void assignRoles(int admin_user_id, int[] role_ids) {
//
//    }
}
