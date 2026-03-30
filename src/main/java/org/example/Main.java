package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Типо лютые соревнования\n");

        Object[] participants = createParticipantsArray();
        Object[] obstacles = createObstaclesArray();

        System.out.println(" Типо препятствия");
        printObstacles(obstacles);

        System.out.println("\n Участнички");
        printParticipants(participants);

        System.out.println("\n Типо прохождение препятствий\n");
        runCompetition(participants, obstacles);
    }

    static Object[] createParticipantsArray() {
        Object[] participants = new Object[5];

        participants[0] = new Human("Илья", 300, 2);
        participants[1] = new Human("Мария", 250, 1);
        participants[2] = new Cat("Барсичек", 200, 3);
        participants[3] = new Cat("Мурзило", 150, 2);
        participants[4] = new Robot("Робот-Болат", 500, 1);

        return participants;
    }

    static Object[] createObstaclesArray() {
        Object[] obstacles = new Object[4];

        obstacles[0] = new Treadmill(100);
        obstacles[1] = new Wall(1);
        obstacles[2] = new Treadmill(200);
        obstacles[3] = new Wall(2);

        return obstacles;
    }

    static void printObstacles(Object[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] instanceof Treadmill) {
                Treadmill t = (Treadmill) obstacles[i];
                System.out.println("Дорожка: " + t.distance + " м.");
            } else if (obstacles[i] instanceof Wall) {
                Wall w = (Wall) obstacles[i];
                System.out.println("Стена: " + w.height + " м.");
            }
        }
    }

    static void printParticipants(Object[] participants) {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] instanceof Human) {
                Human h = (Human) participants[i];
                System.out.println("Человек: " + h.name + " (бег: " + h.maxRunDistance + " м., прыжок: " + h.maxJumpHeight + " м.)");
            } else if (participants[i] instanceof Cat) {
                Cat c = (Cat) participants[i];
                System.out.println("Кот: " + c.name + " (бег: " + c.maxRunDistance + " м., прыжок: " + c.maxJumpHeight + " м.)");
            } else if (participants[i] instanceof Robot) {
                Robot r = (Robot) participants[i];
                System.out.println("Робот: " + r.name + " (бег: " + r.maxRunDistance + " м., прыжок: " + r.maxJumpHeight + " м.)");
            }
        }
    }

    static void runCompetition(Object[] participants, Object[] obstacles) {
        for (int i = 0; i < participants.length; i++) {
            System.out.println("Участник " + (i + 1) + ":");
            boolean success = true;

            for (int j = 0; j < obstacles.length; j++) {
                if (!success) {
                    System.out.println("  Уходит из соревнований");
                    break;
                }
                success = tryObstacle(participants[i], obstacles[j]);
            }

            if (success) {
                System.out.println("  Результат: ну прошел вообще\n");
            } else {
                System.out.println("  Результат: не прошел\n");
            }
        }
    }

    static boolean tryObstacle(Object participant, Object obstacle) {
        if (obstacle instanceof Treadmill) {
            Treadmill t = (Treadmill) obstacle;
            return tryRun(participant, t.distance);
        } else if (obstacle instanceof Wall) {
            Wall w = (Wall) obstacle;
            return tryJump(participant, w.height);
        }
        return false;
    }

    static boolean tryRun(Object participant, int distance) {
        System.out.print("  Пытается пробежать " + distance + " м. - ");

        if (participant instanceof Human) {
            Human h = (Human) participant;
            if (distance <= h.maxRunDistance) {
                System.out.println("успешно");
                return true;
            } else {
                System.out.println("не смог");
                return false;
            }
        } else if (participant instanceof Cat) {
            Cat c = (Cat) participant;
            if (distance <= c.maxRunDistance) {
                System.out.println("успешно");
                return true;
            } else {
                System.out.println("не смог");
                return false;
            }
        } else if (participant instanceof Robot) {
            Robot r = (Robot) participant;
            if (distance <= r.maxRunDistance) {
                System.out.println("успешно");
                return true;
            } else {
                System.out.println("не смог");
                return false;
            }
        }
        return false;
    }

    static boolean tryJump(Object participant, int height) {
        System.out.print("  Пытается перепрыгнуть стену " + height + " м. - ");

        if (participant instanceof Human) {
            Human h = (Human) participant;
            if (height <= h.maxJumpHeight) {
                System.out.println("успешно");
                return true;
            } else {
                System.out.println("не смог");
                return false;
            }
        } else if (participant instanceof Cat) {
            Cat c = (Cat) participant;
            if (height <= c.maxJumpHeight) {
                System.out.println("успешно");
                return true;
            } else {
                System.out.println("не смог");
                return false;
            }
        } else if (participant instanceof Robot) {
            Robot r = (Robot) participant;
            if (height <= r.maxJumpHeight) {
                System.out.println("успешно");
                return true;
            } else {
                System.out.println("не смог");
                return false;
            }
        }
        return false;
    }
}