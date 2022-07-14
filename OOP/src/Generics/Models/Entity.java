package Generics.Models;

public abstract class Entity<K> {

    private K id;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }
}
