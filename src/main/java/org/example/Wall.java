package org.example;

class Wall {
    int height;

    Wall(int height) {
        this.height = height;
    }

    void overcome(Object participant) {
        if (participant instanceof Human) {
            Human human = (Human) participant;
            human.jump(height);
        } else if (participant instanceof Cat) {
            Cat cat = (Cat) participant;
            cat.jump(height);
        } else if (participant instanceof Robot) {
            Robot robot = (Robot) participant;
            robot.jump(height);
        }
    }
}