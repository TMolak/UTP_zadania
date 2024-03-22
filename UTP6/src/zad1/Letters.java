package zad1;

import java.util.ArrayList;
import java.util.List;


public class Letters implements Runnable {

    private List<Thread> threads;

    public Letters(String letters) {
        this.threads = new ArrayList<>();
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            String threadName = new String("Thread " + letter);
            threads.add(new Thread(this, threadName));
        }
    }

    public List<Thread> getThreads() {
        return threads;
    }

    @Override
    public void run() {
        char letter = Thread.currentThread().getName().charAt(7);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            System.out.print(letter);
        }
    }
}


