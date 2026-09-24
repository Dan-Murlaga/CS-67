// Author: Alvin Dong
// Edited by: Dan Murlaga
// AI disclosure: AI was used to generate the majority of the documentation and
// the getter methods for the Building class and its subclasses. I have read the
// comments that Claude outputted to verify the accuracy of the function/constructor
// descriptions.

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Building> townBuildings = new ArrayList<>();
        Random rng = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int numBuildings;
        System.out.print("How many buildings would you like to generate? ");
        numBuildings = scanner.nextInt();
        scanner.nextLine(); // consume the newline character after the integer input

        for (int i=0; i<numBuildings; i++) {
            int capacity;

            System.out.print("\nEnter the type of building to generate (Store, Hotel, House, or Cafe): ");
            String buildingType = scanner.nextLine();

            switch (buildingType.toLowerCase()) {

                case "store" -> {
                    System.out.print("Enter the name of the store: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the capacity of the store: ");
                    try {
                        capacity = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid store capacity.");
                        scanner.nextLine(); // consume the invalid input
                        continue;
                    }

                    System.out.print("Enter the kind of goods the store sells: ");
                    String kind = scanner.nextLine();

                    townBuildings.add(new Store(name, generateStreetAddress(rng), capacity, kind));
                    break;
                }

                case "cafe" -> {
                    System.out.print("Enter the name of the cafe: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the capacity of the cafe: ");
                    try {
                        capacity = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid cafe capacity.");
                        scanner.nextLine(); // consume the invalid input
                        continue;
                    }

                    System.out.print("Enter the type of the cafe: ");
                    String kind = scanner.nextLine();

                    System.out.print("Enter the hours the cafe is open (e.g. 8:00 AM - 8:00 PM): ");
                    String hoursOpen = scanner.nextLine();

                    townBuildings.add(new Cafe(name, generateStreetAddress(rng), capacity, kind, hoursOpen));
                    break;
                }

                case "hotel" -> {
                    int floors;
                    System.out.print("Enter the name of the hotel: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the capacity of the hotel: ");
                    try {
                        capacity = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid hotel capacity.");
                        scanner.nextLine(); // consume the invalid input
                        continue;
                    }

                    System.out.print("Enter the number of floors in the hotel: ");
                    try {
                        floors = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid number of floors.");
                        scanner.nextLine(); // consume the invalid input
                        continue;
                    }

                    townBuildings.add(new Hotel(name, generateStreetAddress(rng), capacity, floors));
                    break;
                }

                case "house" -> {
                    int squareFeet;
                    System.out.print("Enter the capacity of the house: ");
                    try {
                        capacity = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid house capacity.");
                        scanner.nextLine(); // consume the invalid input
                        continue;
                    }

                    System.out.print("Enter the square footage of the house: ");
                    try {
                        squareFeet = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid square footage.");
                        scanner.nextLine(); // consume the invalid input
                        continue;
                    }

                    townBuildings.add(new House(generateStreetAddress(rng), capacity, squareFeet));
                    break;
                }

                default -> System.out.println("Invalid building type. Please enter Store, Hotel, or House.");

            }
        }

        scanner.close(); 

        // Print each building out
        // Each individual Building subclass has a custom toString method that overrides the base Building implementation
        // of the toString method.
        System.out.println("\nGenerated Buildings:");
        for (Building building : townBuildings) {
            System.out.println(building);
        }
    }
    
    /**
     * Generates a random street address with an ordinal street number (e.g. "123 45th Avenue").
     *
     * @param rng random source used to pick the house number, street number, and street type
     * @return a randomly generated street address
     */
    public static String generateStreetAddress(Random rng) {
        int streetNumber = rng.nextInt(1, 100);
        String finalText = "";
        if (streetNumber % 10 == 1) {
            finalText += streetNumber + "st";
        } else if (streetNumber % 10 == 2) {
            finalText += streetNumber + "nd";
        } else if (streetNumber % 10 == 3) {
            finalText += streetNumber + "rd";
        } else {
            finalText += streetNumber + "th";
        }
        if (rng.nextBoolean()) {
            finalText += " Avenue";
        } else {
            finalText += " Street";
        }
        finalText = "%d %s".formatted(rng.nextInt(1, 10000), finalText);
        return finalText;
    }
}
