package com.hzm.feignservicecomdemo.pojo;

import java.io.Serializable;

/**
 * @author
 * @createTime 2020/12/7 18:20
 */
public class User implements Serializable {

    private Integer  id;
    private String  username;
    private String  remark;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
