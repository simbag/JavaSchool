import sun.awt.windows.ThemeReader;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("task1");
        Task task2 = new Task("task2");
        Task task3 = new Task("task3");
        Task task4 = new Task("task4");
        Task task5 = new Task("task5");
        Task task6 = new Task("task6");
        Task task7 = new Task("task7");
        Task task8 = new Task("task8");

        FixedTreadPool fixedTreadPool = new FixedTreadPool(5);
        fixedTreadPool.start();

        fixedTreadPool.execute(task1);
        fixedTreadPool.execute(task2);
        fixedTreadPool.execute(task3);
        fixedTreadPool.execute(task4);
        fixedTreadPool.execute(task5);
        fixedTreadPool.execute(task6);

        fixedTreadPool.stop();

        ScalableThreadPool scalableThreadPool = new ScalableThreadPool(1, 3);
        scalableThreadPool.start();

        scalableThreadPool.execute(task1);
        scalableThreadPool.execute(task2);
        scalableThreadPool.execute(task3);
        scalableThreadPool.execute(task4);
        scalableThreadPool.execute(task5);
        scalableThreadPool.execute(task6);


    }
}
