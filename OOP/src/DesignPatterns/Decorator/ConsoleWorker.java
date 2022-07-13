package DesignPatterns.Decorator;

public final class ConsoleWorker implements Worker {
    @Override
    public void work(String input) {
        System.out.println(input);
    }
}
