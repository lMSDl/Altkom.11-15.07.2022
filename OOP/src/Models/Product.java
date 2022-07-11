package Models;

public class Product /*extends Object*/ {
    private String name;
    private float price;
    String sku;
    protected String getName() {
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
        return String.format("%s: %.2f zł", name, getPrice());
    }


}
