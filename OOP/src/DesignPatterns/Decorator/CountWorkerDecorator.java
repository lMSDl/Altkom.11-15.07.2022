package DesignPatterns.Decorator;

public class CountWorkerDecorator extends WorkerDecorator //implements Worker
{
    public CountWorkerDecorator(Worker worker) {
        super(worker);
    }

    @Override
    protected void extraWork(String input) {
        System.out.println("Counting:");
        for (int i = 1; i <=10; i++) {
            System.out.println(i);
        }
    }

    /*private Worker worker;

    public CountWorkerDecorator(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void work(String input) {

        worker.work(input);

        System.out.println("Counting:");
        for (int i = 1; i <=10; i++) {
            System.out.println(i);
        }
    }*/

}
