package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializer {

    private String fileName = null;

    public ObjectSerializer(String fileName){
        this.fileName = fileName;
    }

    // Serialize
    public boolean WriteObjectToFile(Object serObj) {  // why boolean ?

        try {

            FileOutputStream fileOut = new FileOutputStream(this.fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // Deserialize
    public Object ReadObjectFromFile() {   // why and this type object
        Object scannedObj = null;

        try {

            FileInputStream fileIn = new FileInputStream(this.fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            scannedObj = objectIn.readObject();
            objectIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return scannedObj;
    }
}
