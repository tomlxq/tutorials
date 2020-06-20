package com.tom.optionalreturntype;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeOptionalTypeExample {


    public static void serializeObject(Object object, String fileName) {
        // Serialization
        try (FileOutputStream file = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(file)) {


            out.writeObject(object);


            System.out.println("Object " + object.toString() + " has been serialized to file " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
