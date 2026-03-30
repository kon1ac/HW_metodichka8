package org.example;

class Human {
    String name;
    int maxRunDistance;
    int maxJumpHeight;

    Human(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не пробежал " + distance + " м.");
        }
    }

    void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " перепрыгнул стену высотой " + height + " м.");
        } else {
            System.out.println(name + " не перепрыгнул стену высотой " + height + " м.");
        }
    }
}