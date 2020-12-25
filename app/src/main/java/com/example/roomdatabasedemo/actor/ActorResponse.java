package com.example.roomdatabasedemo.actor;

import java.util.List;

public class ActorResponse {
    List<Actor>actors;

    public List<Actor> getActors() {
        return actors;
    }

    public ActorResponse(List<Actor> actors) {
        this.actors = actors;
    }
}
