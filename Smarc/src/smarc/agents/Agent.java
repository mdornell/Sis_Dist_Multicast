package agents;

public abstract class Agent implements Runnable {
    protected String name;

    public Agent(String name) {
        this.name = name;
    }

    public abstract void performTask();

    @Override
    public void run() {
        while (true) {
            performTask();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
