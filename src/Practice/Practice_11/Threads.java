package Practice.Practice_11;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {

    static int totalSum;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            work(i, false);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);

        totalSum = 0;
        startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI, false));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);

        threads.clear();
        totalSum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI, true));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i, boolean synchr) {
        long startTime = System.currentTimeMillis();
        long result;
        if (synchr)
            result = doHardWork_synchronized(i * 100, 100_000_000);
        else
            result = doHardWork(i * 100, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private synchronized static long doHardWork_synchronized(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * Math.abs(start - i) * Math.sqrt(start + i);
            totalSum++;
        }
        return a;
    }
    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * Math.abs(start - i) * Math.sqrt(start + i);
            totalSum++;
        }
        return a;
    }
}
