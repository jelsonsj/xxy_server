package com.xxy.api.service.impl;

import com.xxy.api.entity.AdminPermission;
import com.xxy.api.service.IPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Override
    public List<AdminPermission> findAdminPermissionList(int type) {
        return null;
    }

    @Override
    public void addAdminPermission(AdminPermission adminPermissionDto) {

    }

    @Override
    public void updateAdminPermission(AdminPermission adminPermissionDto) {

    }

    @Override
    public void deleteAdminPermission(int[] ids) {

    }

    @Override
    public AdminPermission findAdminPermissionById(int id) {
        return null;
    }
}
