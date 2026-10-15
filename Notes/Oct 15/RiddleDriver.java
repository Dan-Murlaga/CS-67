import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RiddleDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream inStream = new FileInputStream("RiddleChallenge.dat");

        ObjectInputStream objectInputFile = new ObjectInputStream(inStream);

        Riddle myRiddle = (Riddle) objectInputFile.readObject();
        objectInputFile.close();

        myRiddle.getQuestion();
        myRiddle.getAnswer();
    }
}
