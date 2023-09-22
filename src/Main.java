class AnimalThread extends Thread {
    private String name;
    private int priority;
    private int distance;

    public AnimalThread(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.distance = 0;
        setPriority(priority);
    }

    public void run() {
        while (distance < 100) {
            distance += 1;
            System.out.println(name + " преодолел " + distance + " метров.");
            try {
                Thread.sleep(100); // Задержка для имитации движения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " финишировал!");
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY);

        rabbit.start();
        turtle.start();

        try {
            rabbit.join();
            turtle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Гонка завершена!");
    }
}
