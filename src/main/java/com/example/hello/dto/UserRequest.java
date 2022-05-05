package com.example.hello.dto;

public class UserRequest {
    private String name;
    private String email;
    private int age;

    public String getNamne() {
        return name;
    }

    public void setNamne(String namne) {
        this.name = namne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            '}';
    }
}
