package com.MajkGroup.MajkAPP.Domain;

import java.util.Objects;

public class User {
    private String FullName, LogName, email, password;
    private int id;

    public User() {
    }

    public User(String fullname, String logname, String password, String email) {
        this.FullName = fullname;
        this.LogName = logname;
        this.password = password;
        this.email = email;

    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullname) {
        this.FullName = fullname;
    }

    public String getLogName() {
        return LogName;
    }

    public void setLogName(String logname) {
        this.LogName = logname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(FullName, user.FullName) && Objects.equals(LogName, user.LogName) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FullName, LogName, email, password, id);
    }

    @Override
    public String toString() {
        return "User{" +
                "FullName='" + FullName + '\'' +
                ", LogName='" + LogName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
