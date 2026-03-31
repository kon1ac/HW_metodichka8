package org.example;

public class Human implements Participant {
    String name;
    int maxRunDistance;
    int maxJumpHeight;

    Human(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    @Override
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}