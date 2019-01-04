package com.dongzj.mb.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/9/10
 * Time: 17:56
 */
@Data
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = -8535865455003355873L;

    private Long id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
