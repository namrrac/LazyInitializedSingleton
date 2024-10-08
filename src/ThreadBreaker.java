package src;

import java.util.ArrayList;
import java.util.List;

public class ThreadBreaker implements Runnable {
    private String threadname;

    public ThreadBreaker(String threadname) {
        this.threadname = threadname;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            threads.add(
                    new Thread(
                            new ThreadBreaker("Thread " + i)));


        }
        for ( Thread t : threads) {
            t.start();
        }
        //LazyInitializedSingleton
    }

    @Override
public void run() {
        //LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
        ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
        System.out.println("running " + this.getThreadname() + instance.hashCode());
    }
    public String getThreadname() {
        return threadname;
    }
}

