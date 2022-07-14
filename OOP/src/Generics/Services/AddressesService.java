package Generics.Services;

import Generics.Interfaces.IAddressesService;
import Generics.Models.Address;

import java.util.Random;

public class AddressesService extends CrudService<Address, Long> implements IAddressesService {

    @Override
    protected Long GenerateId() {
        return new Random().nextLong();
    }
}
