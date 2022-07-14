package Generics.Services;

import Generics.Interfaces.IAddressesService;
import Generics.Interfaces.ICrudService;
import Generics.Models.Address;
import Generics.Models.Entity;

import java.util.Random;

public abstract class CrudService<T extends Entity<K>, K> implements ICrudService<T, K> {
    @Override
    public K Create(T entity) {
        var randomInt = new Random().nextInt();
        var id = GenerateId();
        entity.setId(id);
        return id;
    }

    @Override
    public T Read(K id) {
        return null;
    }

    @Override
    public T[] Read() {
        return null;
    }

    @Override
    public boolean Update(K id, T entity) {
        return false;
    }

    @Override
    public boolean Delete(K id) {
        return false;
    }

    protected abstract K GenerateId();

    public <E> E Cast(T entity) throws ClassCastException
    {
        return (E)entity;
    }
}
