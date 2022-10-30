package org.example.service.zy.serviceInterface;

import org.example.entity.User;
import org.example.service.zy.entity.ResultVo;

/**
 * @author zy
 */
public interface UserService {

    ResultVo register(User user);
    ResultVo login(User user);
    String md5(String password);
}
