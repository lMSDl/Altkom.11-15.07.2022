import Models.Product;

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
    }

    /*static void addToPrice(Product product, float value) {
        product.price += value;
    }*/
}