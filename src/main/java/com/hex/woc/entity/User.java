package com.hex.woc.entity;
import lombok.Data;
import lombok.ToString;

/**
 * @author Hex
 * @version 1.0
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;

}
