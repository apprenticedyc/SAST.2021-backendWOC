package com.hex.woc.Service.User;

import com.hex.woc.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hex
 * @version 1.0
 */
@Service
public interface UserService {

    List<User> selectAll();
    User selectByName(String name);
    int updateUser(User user);
    String uploadUser(User user);
    String login(User user);

}
