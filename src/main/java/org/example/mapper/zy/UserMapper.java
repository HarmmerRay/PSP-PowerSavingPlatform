package org.example.mapper.zy;

import org.example.entity.User;

import java.util.List;

/**
 * @author zy
 */
public interface UserMapper {
    public int insertUser(User user);
    public int deleteUser(User user);
    public int updateUser(User user);
    public User selectUser(User user);
    public List<User> selectAll();
}
