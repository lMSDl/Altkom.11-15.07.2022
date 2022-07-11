package Models;

public class CraftedProduct extends Product {

    private boolean safety = true;

    public CraftedProduct(String name) {
        super(name);
    }

    public void removeSafety() {
        safety = false;
    }
}
