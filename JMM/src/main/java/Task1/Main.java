package Task1;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Callable<Integer> callable = () -> 10;

        Runnable runnable = new Runnable() {
            Task<Integer> task = new Task<>(callable);

            @Override
            public void run() {
                try {
                    System.out.println(task.get());
                } catch (TaskException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
