package Models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BeansObject implements Serializable {

    private String name;
    private int value;

    public BeansObject() {
        name = "aaa";
    }
    public BeansObject(int value) {
        this();
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
