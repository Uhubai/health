package com.cdut.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cdut.dao.PermissionDao;
import com.cdut.dao.RoleDao;
import com.cdut.dao.UserDao;
import com.cdut.pojo.Permission;
import com.cdut.pojo.Role;
import com.cdut.pojo.User;
import com.cdut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * 用户服务
 */
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    //根据用户名查询数据库获取用户信息和关联的角色信息，同时查询角色关联的权限信息
    @Override
    public User findByUsername(String username) {
        //查询用户基本信息，不包含用户的角色
        User user = userDao.findByUsername(username);
        if (user == null) {
            return null;
        }
        Integer id = user.getId();
        //根据用户id查询用户角色
        Set<Role> roles = roleDao.findByUserId(id);
        for (Role role : roles) {
            Integer roleId = role.getId();
            //根据角色id查询关联的权限信息
            Set<Permission> permissions = permissionDao.findByRoleId(roleId);
            //让角色关联权限
            role.setPermissions(permissions);
        }
        user.setRoles(roles);
        return user;
    }
}
