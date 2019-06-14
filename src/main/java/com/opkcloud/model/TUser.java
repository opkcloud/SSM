package com.opkcloud.model;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2019/6/14
 * @Description: com.opkcloud.model
 * @version: 1.0
 */
public class TUser {
    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}