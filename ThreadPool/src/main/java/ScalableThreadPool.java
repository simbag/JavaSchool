import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ScalableThreadPool implements ThreadPool {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private List<ThreadWorker> threadWorkers = new ArrayList<>();
    private int minThreadsCount;
    private int maxThreadsCount;

    public ScalableThreadPool(int minThreadsCount, int maxThreadsCount) {
        this.minThreadsCount = minThreadsCount;
        this.maxThreadsCount = maxThreadsCount;

        for (int i = 0; i < minThreadsCount; i++) {
            threadWorkers.add(new ThreadWorker());
        }
    }

    public void start() {
        for (ThreadWorker threadWorker : threadWorkers) {
            threadWorker.start();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            tasks.notify();
            scaleThreadPool();
        }
    }

    private void scaleThreadPool() {
        if (minThreadsCount < tasks.size() && tasks.size() <= maxThreadsCount) {
            System.out.println("Количество задач: " + tasks.size() + " Количество потоков: " + threadWorkers.size());
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorkers.add(threadWorker);
            threadWorker.start();
            System.out.println("Количество задач: " + tasks.size() + " Количество потоков: " + threadWorkers.size() + ". Создан поток "+threadWorker.getName());


        } else if (minThreadsCount >= tasks.size() && threadWorkers.size() > minThreadsCount) {
            System.out.println("Количество задач: " + tasks.size() + " Количество потоков: " + threadWorkers.size());
            ThreadWorker threadWorker = threadWorkers.get(threadWorkers.size() - 1);
            threadWorker.interrupt();
            threadWorkers.remove(threadWorker);
            System.out.println("Количество задач: " + tasks.size() + " Количество потоков: " + threadWorkers.size() + ". Удален поток " + threadWorker.getName());

        }
    }

    private final class ThreadWorker extends Thread {
        Runnable task;

        @Override
        public void run() {
            while (!this.isInterrupted()) {
                try {
                    synchronized (tasks) {
                        while (tasks.isEmpty()) {
                            scaleThreadPool();
                            tasks.wait();
                        }
                        task = tasks.poll();
                    }
                    task.run();
                } catch (InterruptedException e) {
                    this.interrupt();
                }
            }
        }
    }

}
