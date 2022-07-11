package Models;

public class Product {

    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public float getPrice() {
        return price;
    }

    public void addToPrice(float valueToAdd) {
        this.price += valueToAdd;
    }

    public String getInfo() {
        return String.format("%s: %.2f zł", name, price);
    }


}
