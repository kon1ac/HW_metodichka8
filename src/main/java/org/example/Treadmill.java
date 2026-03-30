package org.example;

class Treadmill {
    int distance;

    Treadmill(int distance) {
        this.distance = distance;
    }

    void overcome(Object participant) {
        if (participant instanceof Human) {
            Human human = (Human) participant;
            human.run(distance);
        } else if (participant instanceof Cat) {
            Cat cat = (Cat) participant;
            cat.run(distance);
        } else if (participant instanceof Robot) {
            Robot robot = (Robot) participant;
            robot.run(distance);
        }
    }
}