package com.example.fox.mrtestproject.entity;

public class User{

    private int id;
    private String name;
    private String classRoom;
    private int time;
    private int points;

    public User(int id, String name, String classRoom, int time, int points) {
        this.id = id;
        this.name = name;
        this.classRoom = classRoom;
        this.time = time;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
