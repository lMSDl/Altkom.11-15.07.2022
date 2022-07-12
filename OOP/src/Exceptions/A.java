package Exceptions;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class A {
    public void Test(Object filename) throws PathException, ClassCastException {
        var path = (Path) filename;

        if(path == null || path.toString().isEmpty()) {
            throw new PathException("Parameter filename cannot be empty");
        }
    }
}
