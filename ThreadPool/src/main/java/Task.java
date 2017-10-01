import sun.awt.windows.ThemeReader;

public class Task implements Runnable {
    String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        int sum = 0;
        System.out.println("Задание " + taskName + " выполняется потоком " + Thread.currentThread().getName());

        for (int i = 0; i < 500000; i++) {
            sum += i * 2;
            for (int j = 0; j < 5000; j++) {
                sum += j * 2;
            }
        }
        System.out.println(sum);
        System.out.println("Задание: " + taskName + " выполнено потоком " + Thread.currentThread().getName());
    }
}
