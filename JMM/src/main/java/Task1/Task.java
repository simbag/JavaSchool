package Task1;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Callable<? extends T> callable;
    private volatile TaskException taskException;
    private volatile T result;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws TaskException {

        if (result != null) {
            System.out.println(Thread.currentThread().getName()+". Значение уже посчитано");
            return result;
        }
        if (taskException != null) {
            throw taskException;
        }

        //Если первым запустится поток с именем Thread-0, все потоки кинут TaskException
        if (Thread.currentThread().getName().equals("Thread-0")) {
            taskException = new TaskException("Ошибка в потоке Thread-0!");
            throw taskException;
        }

        synchronized (callable) {
            try {
                result = callable.call();
            } catch (Exception e) {
                taskException = new TaskException(e.getMessage());
                throw taskException;
            }
        }

        return result;
    }
}
