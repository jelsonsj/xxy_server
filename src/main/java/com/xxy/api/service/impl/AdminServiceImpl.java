package com.xxy.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxy.api.entity.AdminUser;
import com.xxy.api.entity.QueryDto;
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

    @Override
    public AdminUser findAdminUserById(Long id) {
        return adminUserMapper.findAdminUserById(id);
    }

    @Override
    public List<AdminUser> findAdminUserList(QueryDto dto) {
        PageHelper.startPage(dto.getPage().getCurrentPage(),dto.getPage().getPageSize());
        return adminUserMapper.findAdminUserList(dto);
    }

    @Override
    public Boolean addAdminUser(AdminUser adminUser) {
        Long ret=adminUserMapper.addAdminUser(adminUser);
        return  ret>0?true:false;
    }

    @Override
    public Boolean updateAdminUser(AdminUser adminUser) {

        AdminUser old=adminUserMapper.findAdminUserById(adminUser.getUser_id());
        Long ret=adminUserMapper.updateAdminUser(adminUser);
        return ret>0?true:false;
    }

    @Override
    public Boolean deleteAdminUser(int[] ids) {
        Long ret=adminUserMapper.deleteAdminUser(ids);
        return ret>0?true:false;
    }

}
