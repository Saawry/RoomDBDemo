package com.example.roomdatabasedemo.actor;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "actor_table")
public class Actor {
    @PrimaryKey(autoGenerate = true)
    private int LocalId;
    private String id;
    private String name;
    private String image;
    private String age;

    public Actor(String id, String name, String image, String age) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}