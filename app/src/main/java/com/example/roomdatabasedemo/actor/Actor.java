package com.example.roomdatabasedemo.actor;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "actor_table")
public class Actor {
    @PrimaryKey(autoGenerate = true)
    private int LocalId;
    private int id;
    private String name;
    private String image;
    private int age;

    public Actor(int id, String name, String image, int age) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}