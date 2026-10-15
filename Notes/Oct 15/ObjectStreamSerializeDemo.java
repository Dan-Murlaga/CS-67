import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamSerializeDemo {

    public static void main(String[] args) throws IOException {
        //create a file Object.dat
        FileOutputStream outStream = new FileOutputStream("Object.dat");

        //create an ObjectOutputStream to write to the file
        ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);

        //create an object to write to the file (note that MyClass must implement Serializable)
        MyClass anObject = new MyClass(69);

        //write the object to the file
        objectOutputFile.writeObject(anObject);

        //close the files
        objectOutputFile.close();
        outStream.close();
    }
}