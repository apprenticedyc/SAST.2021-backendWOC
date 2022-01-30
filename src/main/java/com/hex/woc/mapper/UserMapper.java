package com.hex.woc.mapper;

import com.hex.woc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hex
 * @version 1.0
 */

@Mapper
@Repository
//@Repository将类标识为bean
public interface UserMapper {
    List<User> selectAll();
    User selectByName(String name);
    int updateUser(User user);
    void save(User user);
    void deleteUserById(Integer Id);
}
