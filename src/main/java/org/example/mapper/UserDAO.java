package org.example.mapper;

import org.example.entity.User;

public interface UserDAO {
    // 添加用户
    int addUser(User user);
    // 根据用户名查询用户
    User getUserByName(String name);
}

