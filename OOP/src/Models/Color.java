package Models;

public class Color extends Entity {

    private String colorCode;

    public Color(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

}
