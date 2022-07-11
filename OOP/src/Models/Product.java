package Models;

public class Product {

    public String name;
    public float price;

    public String getInfo() {
        return String.format("%s: %.2f zł", name, price);
    }


}
