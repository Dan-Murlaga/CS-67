/**
 * This program demonstrates object deserialization 
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDeserializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //OPEN a file Object.dat
        FileInputStream inStream = new FileInputStream("Object.dat");

        //create an ObjectInputStream to read in data from the file
        ObjectInputStream objectInputFile = new ObjectInputStream(inStream);

        // read in the data into a MyClass object
        MyClass anObject = (MyClass) objectInputFile.readObject();

        // print it out!
        System.out.println(anObject);

        //close the files
        objectInputFile.close();
        inStream.close();
    }
}