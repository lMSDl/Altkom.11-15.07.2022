package Generics.Services;

import Generics.Interfaces.IPeopleService;
import Generics.Models.Person;

import java.util.Random;

public class PeopleService extends CrudService<Person, Integer> implements IPeopleService {

    @Override
    public Person[] ReadByName(String firstName) {
        return new Person[0];
    }

    @Override
    protected Integer GenerateId() {
        return new Random().nextInt();
    }
}
