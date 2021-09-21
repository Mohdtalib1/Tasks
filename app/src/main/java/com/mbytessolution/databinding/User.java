package com.mbytessolution.databinding;

public class User {

    private String name;
    private String imageUrl;
    private int age;
    private boolean active;

    public User(String name, String imageUrl, int age, boolean active) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.age = age;
        this.active = active;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
