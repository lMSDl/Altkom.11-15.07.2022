import DesignPatterns.Decorator.ConsoleWorker;
import DesignPatterns.Decorator.CountWorkerDecorator;
import DesignPatterns.Decorator.HashWorkerDecorator;
import DesignPatterns.Decorator.Worker;
import Exceptions.A;
import Exceptions.PathException;
import InnerClasses.OuterClass;
import Interfaces.CashRegisterService;
import Models.*;

import java.beans.XMLEncoder;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {

        var outer = new OuterClass(50);
        OuterClass.MemberClass inner = outer.new MemberClass();

        var product1 = new Product("Kubek");
        product1.addToPrice(32.99f);

        int value = 10;

        outer.someMethod(new CashRegisterService() {
            @Override
            public void readSku(Product product) {
                outer.calculate(1, 2, 3);
                product1.addToPrice(10);
                System.out.println("No Access to SKU");

                System.out.println(value);
            }
        }, product1);

        System.out.println(new OuterClass.StaticInnerClass().test());

        try {
            fileOperation(product1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        var beans = new BeansObject();
        //beans.setName("Beans");
        beans.setValue(2);
        try {
            serialize(beans);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Worker worker = new ConsoleWorker();
        worker = new HashWorkerDecorator(worker);
        worker = new CountWorkerDecorator(worker);
        worker = new HashWorkerDecorator(worker);

        worker.work("some data");
    }

    private static void serialize(Serializable serializable) throws IOException {
        try (var encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("item.xml")))) {
            encoder.writeObject(serializable);
        } catch (FileNotFoundException e) {
        }
    }

    private static void fileOperation(Product product1) throws IOException {
        var file = new File("product.txt");
        var append = file.exists();
        //var fileWriter = new FileWriter(file, append);
        try (var fileWriter = new FileWriter(file, append)) {
            fileWriter.write(product1.getInfo());
            //fileWriter.flush();
        }
        //finally {
        //    fileWriter.close();
        //}
    }

    private static void part1() {
        var product1 = new Product("Kubek");
        //product1.name = "Kubek";
        //product1.price = 32.99f;
        product1.addToPrice(32.99f);
        System.out.println(product1.getInfo());
        product1.addToPrice(10);
        System.out.println(product1.getInfo());

        product1.setExpirationDate(product1.getCreatedAt().plusDays(360).toLocalDate());
        product1.showTimeToExpire();

        var product2 = new Product("pIŁkA");
        //product2.name = "Piłka";
        //product2.price = 19.50f;
        //product2.setName("pIŁkA");
        product2.addToPrice(19.50f);
        System.out.println(product2.getInfo());

        var clockHand1 = new ClockHand("hour");
        clockHand1.addToPrice(3);
        var clockHand2 = new ClockHand("minute");
        clockHand2.addToPrice(2);
        var clockHand3 = new ClockHand("second");
        clockHand3.addToPrice(1);
        var hanger = new Hanger("wieszak");
        //hanger.setName("wieszak");
        hanger.addToPrice(0.3f);
        var clock = new WallClock("Zegar ścienny", clockHand1, clockHand2, clockHand3, hanger);
        clock.addToPrice(15);
        //clock.setName("Zegar ścienny");

        System.out.println(clock.getInfo());

        AnalogClock clock2 = clock;
        System.out.println(clock2.getInfo());
        System.out.println(clock2.getTime());

        var products = new Product[] { product1, product2, clock, clockHand3};
        var order = new Order(products);

        System.out.printf("Suma zamówienia: %.2f\n", order.getPrice());

        var product3 = (Product)clock;
        order.add(product1);
        order.add(clock);
        //order.add(clock);
        order.add((AnalogClock)product3);
        //order.addClock((AnalogClock)product1);

        int a = 15;
        long b = 1231231231222222231L;

        a = (int)b;
        b = a;

        System.out.println(clock);


        var classA = new A();
        try {
            classA.Test(3);
        }
        catch (PathException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*static void addToPrice(Product product, float value) {
        product.price += value;
    }*/
}