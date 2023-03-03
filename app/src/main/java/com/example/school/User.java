package com.example.school;

public class User {
    private String name;
    private String pwd;
    private String url;
    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public User(String name, String pwd, String url) {
        this.name = name;
        this.pwd = pwd;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
