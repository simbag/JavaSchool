import java.util.*;

public class FixedTreadPool implements ThreadPool {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private List<ThreadWorker> threadWorkers = new ArrayList<>();

    public FixedTreadPool(int threadsCount) {
        for (int i = 0; i < threadsCount; i++) {
            threadWorkers.add(new ThreadWorker());
        }
    }

    public void start() {
        for (ThreadWorker threadWorker : threadWorkers) {
            threadWorker.start();
        }
    }

    public void stop() {
        for (ThreadWorker threadWorker : threadWorkers) {
            try {
                threadWorker.interrupt();
                threadWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void execute(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            tasks.notify();
        }
    }

    private final class ThreadWorker extends Thread {
        Runnable task;

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (tasks) {
                        while (tasks.isEmpty()) {
                            tasks.wait();
                        }
                        task = tasks.poll();
                    }
                    task.run();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}

