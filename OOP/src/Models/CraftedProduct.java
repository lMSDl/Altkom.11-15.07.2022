package Models;

public class CraftedProduct extends Product {

    private boolean safety = true;

    public void removeSafety() {
        safety = false;
    }
}
