package org.example;

public class Treadmill extends AbstractObstacle {
    int distance;

    Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant participant) {
        System.out.print("  " + participant.getName() + " пытается пробежать " + distance + " м. - ");

        if (distance <= participant.getMaxRunDistance()) {
            System.out.println("успешно");
            return true;
        } else {
            System.out.println("не смог");
            return false;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Дорожка: " + distance + " м.");
    }
}