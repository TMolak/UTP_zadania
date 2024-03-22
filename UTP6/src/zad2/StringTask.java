package zad2;

enum TaskState {
    CREATED,
    RUNNING,
    ABORTED,
    READY
}

public class StringTask implements Runnable {

    private final String napis;
    private volatile String napisWynik = "";
    private volatile int powielenia;
    private Thread thread;
    private TaskState stan;

    public StringTask(String napis, int powielenia) {
        this.napis = napis;
        this.powielenia = powielenia;
        this.stan = TaskState.CREATED;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            if (powielenia>0){
                napisWynik += napis;
                powielenia--;
            }else{
                stan = TaskState.READY;
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getResult() {
        return napisWynik;
    }

    public TaskState getState() {
        return stan;
    }

    public void start() {
        thread = new Thread(this);
        stan = TaskState.RUNNING;
        thread.start();
    }

    public void abort() {
        thread.interrupt();
        stan = TaskState.ABORTED;
    }

    public boolean isDone() {
        if (stan == TaskState.READY || stan == TaskState.ABORTED) {
            return true;
        }else {
            return false;
        }
    }

}
