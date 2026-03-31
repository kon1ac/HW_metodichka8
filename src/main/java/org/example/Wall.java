package org.example;

public class Wall extends AbstractObstacle {
    int height;

    Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        System.out.print("  " + participant.getName() + " пытается перепрыгнуть стену " + height + " м. - ");

        if (height <= participant.getMaxJumpHeight()) {
            System.out.println("успешно");
            return true;
        } else {
            System.out.println("не смог");
            return false;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Стена: " + height + " м.");
    }
}