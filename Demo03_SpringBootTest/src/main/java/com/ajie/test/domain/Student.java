package com.ajie.test.domain;

/**
 * @author ajie
 * @date 2023/7/12
 * @description: 实体类对象
 */
public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Integer classId;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String address, Integer classId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classId = classId;
    }

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
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", classId=" + classId +
                '}';
    }
}
