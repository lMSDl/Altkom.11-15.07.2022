package DesignPatterns.Decorator;

public abstract class WorkerDecorator implements Worker{

    private Worker worker;

    public WorkerDecorator(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void work(String input) {
        worker.work(input);
        extraWork(input);
    }

    protected abstract void extraWork(String input);
}
