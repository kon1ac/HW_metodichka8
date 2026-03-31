package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Типо лютые соревнования\n");

        Participant[] participants = createParticipantsArray();

        AbstractObstacle[] obstacles = createObstaclesArray();

        System.out.println(" Типо препятствия");
        printObstacles(obstacles);

        System.out.println("\n Участнички");
        printParticipants(participants);

        System.out.println("\n Типо прохождение препятствий\n");
        runCompetition(participants, obstacles);
    }

    static Participant[] createParticipantsArray() {
        Participant[] participants = new Participant[5];

        participants[0] = new Human("Илья", 300, 2);
        participants[1] = new Human("Мария", 250, 1);
        participants[2] = new Cat("Барсичек", 200, 3);
        participants[3] = new Cat("Мурзило", 150, 2);
        participants[4] = new Robot("Робот-Болат", 500, 1);

        return participants;
    }

    static AbstractObstacle[] createObstaclesArray() {
        AbstractObstacle[] obstacles = new AbstractObstacle[4];

        obstacles[0] = new Treadmill(100);
        obstacles[1] = new Wall(1);
        obstacles[2] = new Treadmill(200);
        obstacles[3] = new Wall(2);

        return obstacles;
    }

    static void printObstacles(AbstractObstacle[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].printInfo();
        }
    }

    static void printParticipants(Participant[] participants) {
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].getName() + " (бег: " +
                    participants[i].getMaxRunDistance() + " м., прыжок: " +
                    participants[i].getMaxJumpHeight() + " м.)");
        }
    }

    static void runCompetition(Participant[] participants, AbstractObstacle[] obstacles) {
        for (int i = 0; i < participants.length; i++) {
            System.out.println("Участник " + (i + 1) + ":");
            boolean success = true;

            for (int j = 0; j < obstacles.length; j++) {
                if (!success) {
                    System.out.println("  Уходит из соревнований");
                    break;
                }
                // Каждое препятствие само проверяет, может ли участник его преодолеть
                success = obstacles[j].overcome(participants[i]);
            }

            if (success) {
                System.out.println("  Результат: ну прошел вообще\n");
            } else {
                System.out.println("  Результат: не прошел\n");
            }
        }
    }
}