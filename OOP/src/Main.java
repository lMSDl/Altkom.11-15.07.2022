import Models.*;

public class Main {
    public static void main(String[] args) {

        var product1 = new Product();
        //product1.name = "Kubek";
        //product1.price = 32.99f;
        product1.setName("Kuber");
        product1.addToPrice(32.99f);
        System.out.println(product1.getInfo());
        product1.addToPrice(10);
        System.out.println(product1.getInfo());

        var product2 = new Product();
        //product2.name = "Piłka";
        //product2.price = 19.50f;
        product2.setName("pIŁkA");
        product2.addToPrice(19.50f);
        System.out.println(product2.getInfo());

        var clockHand1 = new ClockHand();
        clockHand1.addToPrice(3);
        var clockHand2 = new ClockHand();
        clockHand2.addToPrice(2);
        var clockHand3 = new ClockHand();
        clockHand3.addToPrice(1);
        var hanger = new Hanger();
        hanger.setName("wieszak");
        hanger.addToPrice(0.3f);
        var clock = new WallClock(clockHand1, clockHand2, clockHand3, hanger);
        clock.addToPrice(15);
        clock.setName("Zegar ścienny");

        System.out.println(clock.getInfo());

        Clock clock2 = clock;
        System.out.println(clock2.getInfo());

        var products = new Product[] { product1, product2, clock, clockHand3};
        var order = new Order(products);

        System.out.printf("Suma zamówienia: %.2f\n", order.getPrice());

        var product3 = (Product)clock;
        order.addProduct(product1);
        order.addProduct(clock);
        order.addClock(clock);
        order.addClock((Clock)product3);
        //order.addClock((Clock)product1);

        int a = 15;
        long b = 1231231231222222231L;

        a = (int)b;
        b = a;

        System.out.println(clock);
    }

    /*static void addToPrice(Product product, float value) {
        product.price += value;
    }*/
}