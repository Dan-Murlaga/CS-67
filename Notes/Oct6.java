package Notes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashSet;

public class Oct6 {
    public static void main(String[] args) {
        Random randomNumbers = new Random();

        // Exercise 1
        
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("gb3ifqxgn");
        stringList.add("wugnxoimqzoiq");
        stringList.add("oqiwhemzuiqgnf");

        Collections.sort(stringList);
        System.out.println(stringList);


        ArrayList<Integer> intList = new ArrayList<Integer>();
        
        for (int i=0; i<10; i++) {
            intList.add(randomNumbers.nextInt(100));
        }

        Collections.sort(intList);
        System.out.println(intList);
        

        ArrayList<RocketShip> rocketList = new ArrayList<RocketShip>();
        for (int i=1; i<=3; i++) {
            String rocketName = "Rocket " + i;
            int fuel = randomNumbers.nextInt(100);
            int speed = randomNumbers.nextInt(10000);
            int altitude = randomNumbers.nextInt(100000);
            RocketShip rocket = new RocketShip(rocketName, fuel, speed, altitude);
            rocketList.add(rocket);
        }

        Collections.sort(rocketList);
        System.out.println(rocketList);

        // Exercise 2

        int totalItems = 1000;
        int itemsToSearch = 100;

        ArrayList<Integer> bigIntList = new ArrayList<Integer>();
        for (int i=0; i<totalItems; i++) {
            bigIntList.add(randomNumbers.nextInt(totalItems));
        }

        long startTime = System.nanoTime();
        for (int i=0; i<itemsToSearch; i++) {
            bigIntList.contains(randomNumbers.nextInt(totalItems));
        }
        long endTime = System.nanoTime();

        long timeElapsed = (endTime - startTime);
        System.out.println("Array list execution time in nanoseconds: " + timeElapsed);


        HashSet<Integer> intSet = new HashSet<Integer>();
        for (int i=0; i<totalItems; i++) {
            intSet.add(randomNumbers.nextInt(totalItems));
        }

        startTime = System.nanoTime();
        for (int i=0; i<itemsToSearch; i++) {
            intSet.contains(randomNumbers.nextInt(totalItems));
        }
        endTime = System.nanoTime();

        timeElapsed = (endTime - startTime);
        System.out.println("Hash set execution time in nanoseconds: " + timeElapsed);
    }
}
