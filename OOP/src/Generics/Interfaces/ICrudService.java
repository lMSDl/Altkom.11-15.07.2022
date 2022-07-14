package Generics.Interfaces;

import Generics.Models.Entity;
import Generics.Models.Person;

public interface ICrudService<T extends Entity<K>, K> {
    K Create(T person);
    T Read(K id);
    T[] Read();
    boolean Update(K id, T person);
    boolean Delete(K id);

}
