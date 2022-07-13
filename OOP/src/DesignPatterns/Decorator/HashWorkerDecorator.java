package DesignPatterns.Decorator;

public class HashWorkerDecorator extends WorkerDecorator //implements Worker
{
/*    private Worker worker;

    public HashWorkerDecorator(Worker worker) {
        this.worker = worker;
    }


    @Override
    public void work(String input) {
        worker.work(input);

        System.out.println(input.hashCode());
    }*/
    public HashWorkerDecorator(Worker worker) {
        super(worker);
    }

    @Override
    protected void extraWork(String input) {
        System.out.println(input.hashCode());
    }
}

