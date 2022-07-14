package Generics.Interfaces;

import Generics.Models.Person;

public interface IPeopleService extends ICrudService<Person, Integer> {

    Person[] ReadByName(String firstName);

}
