import DesignPatterns.Builder.VehicleBuilder;
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
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static class MyClass implements Comparable<MyClass> {
        public String a;
        public String b;
        MyClass(String a, String b) { this.a = a; this.b = b; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyClass myClass = (MyClass) o;
            return Objects.equals(a, myClass.a) && Objects.equals(b, myClass.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return a + b;
        }

        @Override
        public int compareTo(MyClass o) {
            var result = a.compareTo(a);
            if(result == 0)
                return equals(o) ? 0 : 1;
            return result;
        }
    }
    @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {


        var stringsBundle = ResourceBundle.getBundle("strings", Locale.GERMANY);

        System.out.println(stringsBundle.getString("name"));
        Locale.setDefault(new Locale("en", "US"));
        stringsBundle = ResourceBundle.getBundle("strings");
        System.out.println(stringsBundle.getString("hello"));


        System.out.println();
        Product product;

        product = new Product("");

        System.out.println(product.getDateTime());
        System.out.println(Product.getStaticDateTime());

        product = new Product("");

        System.out.println(product.getDateTime());
        System.out.println(Product.getStaticDateTime());

    }

    private static void part7() {
        Optional<Product> product = Optional.ofNullable(null);
        // Optional<Product> product = Optional.of(new Product("a"));

        if(product.isPresent())
            System.out.println(product.get());
        product.ifPresent(System.out::println);
        var a = product.orElse(new Product("b"));

        var boxes = Stream.generate(Box::new)
                /*.map(box -> { box.items = Stream.iterate(new Item(1), x -> new Item(x.value + 1) )
                                                .limit(5)
                                                .collect(Collectors.toList());
                                return box;
                })*/
                .peek(box -> box.items = Stream.iterate(new Item(1), x -> new Item(x.value + 1) )
                                                .limit(5)
                                                .collect(Collectors.toList()))
                .limit(5)
                .collect(Collectors.toList());

        var items = boxes.stream().flatMap(x -> x.items.stream()).toList();
        var min = items.stream().mapToInt(x -> x.value).min();
        var average = items.stream().mapToInt(x -> x.value).average();
        var max = items.stream().mapToInt(x -> x.value).max();

        String[] array = new String[] {"ala", "ma", "kota"};
        System.out.println(Arrays.stream(array).reduce((s1, s2) -> s1 + " " + s2).get());

        var partition = items.stream().collect(Collectors.partitioningBy(x -> x.value  == 3));
        var group = items.stream().collect(Collectors.groupingBy(x -> x.value));

    }

    private static void part6() {
        Set<MyClass> s = new TreeSet<>();
        var a = new MyClass("a", "b");
        s.add(a);
        var b = new MyClass("a", "c");
        s.add(b);
        s.add(new MyClass("a", "b"));
        System.out.println(a.equals(b));
        for (MyClass m : s) { System.out.println(m); }

        b.b = "b";
        s.forEach(new Consumer<MyClass>() {
            @Override
            public void accept(MyClass myClass) {
                System.out.println(myClass);
            }
        });



        //s.forEach(x -> System.out.println(x));
        s.forEach(System.out::println);
        /*for (MyClass m : s)
        { System.out.println(m); }*/
    }

    private static void part4() {
        List<?> list1;
        list1 = new ArrayList<Worker>();
        var a = list1.get(1);

        List<? extends Product> list2;
        list2 = new ArrayList<Product>();
        list2 = new ArrayList<WallClock>();
        list2 = new ArrayList<ClockHand>();
        //list2.add(new ClockHand(""));
        var b = list2.get(1);

        List<? super Product> list3;
        list3 = new ArrayList<Product>();
        //list3 = new ArrayList<WallClock>();
        list3 = new ArrayList<Entity>();
        list3.add(new Product(""));
        var c = list3.get(1);
    }

    private static void part3() {
        var builder = new VehicleBuilder();

        builder.setDoors(4).setSeats(5).setEnginePower(100).setTrunkCapacity(500);

        var vehicle = builder.build();
        builder.setEnginePower(150);
        var vehicle2 = builder.build();

        System.out.println(vehicle == vehicle2);
    }


    private static void part2() {
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

        outer.someMethod(x -> {
            outer.calculate(1, 2, 3);
            product1.addToPrice(10);
            System.out.println("No Access to SKU");

            System.out.println(value);
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