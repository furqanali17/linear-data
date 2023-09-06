import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Airline {
    //using arraylist to store unique generated numbers
    static ArrayList<Integer> randStore = new ArrayList<>();
    //making an array of all seats
    static boolean[] Class = new boolean[10];
    static int numFirstClass = 0;
    static int numEconomyClass = 0;
    //using scanner to take input from user
    static Scanner scanner = new Scanner(System.in);
    //generating random array
    static Random randIndex = new Random();
    //using to exit program when all seats booked
    static boolean exit = false;

    private static void booking(){
        int option = scanner.nextInt();
        //if user selects option 1 go through first class
        if (option == 1) firstClass();
            //if user selects option 1 go through first class
        else if (option == 2) economyClass();
            //if user enters anything other than 1 or 2
        else System.out.println("Your input was Invalid, Please type 1 for First Class (OR) type 2 for Economy Class:");
    }

    //method for first class seats
    private static void firstClass(){
        //generating random number index 0-4
        int index = randIndex.nextInt(5);
        if (numFirstClass < Class.length / 2){
            //ensuring the loop runs five time as only 5 seats are for first class
            for (int i = 0; i < Class.length / 2; i++){
                if (!Class[index]){
                    //storing index in array list
                    randStore.add(index);
                    //setting boolean in array to true
                    Class[index] = true;
                    System.out.println("You have selected First Class, your seat number is: #" + (index + 1));
                    System.out.println();
                    numFirstClass++;
                    System.out.println("Please type 1 for First Class (OR) type 2 for Economy Class:");
                    break;
                }else{
                    do {
                        //do while for when repeated randoms are generated
                        index = randIndex.nextInt(5);
                    }while ((randStore.contains(index)));
                }
            }
        }
        //for when first class is full
        else if (numEconomyClass < 5){
            System.out.println("First Class is fully occupied. Press 2 if you would like to book an Economy Class ticket.");
            int choice = scanner.nextInt();
            if (choice == 2)
                economyClass();
            else
                System.out.println("The next flight leaves in 3 hours.");
        }else
            System.out.println("All bookings are full, the next flight leaves in 3 hours.");
        exit = true;
    }

    private static void economyClass(){
        //generating random number index 5-9
        int index = randIndex.nextInt(5) + 5;
        if (numEconomyClass < Class.length / 2){
            //ensuring the loop runs five time as only 5 seats are for first class
            for (int i = 0; i < Class.length / 2; i++){
                if (!Class[index]) {
                    randStore.add(index);
                    Class[index] = true;
                    System.out.println("You have selected Economy Class, your seat number is: #" + (index + 1));
                    System.out.println();
                    numEconomyClass++;
                    System.out.println("Please type 1 for First Class (OR) type 2 for Economy Class:");
                    break;
                }else{
                    do {
                        index = randIndex.nextInt(5) + 5;
                    }while ((randStore.contains(index)));
                }
            }
        }
        else if (numFirstClass < 5){
            System.out.println("Economy Class is fully occupied. Press 1 if you would like to book a First Class ticket.");
            int choice = scanner.nextInt();
            if (choice == 1)
                firstClass();
            else
                System.out.println("The next flight leaves in 3 hours.");
        }else
            System.out.println("All bookings are full, the next flight leaves in 3 hours.");
        exit = true;
    }

    static boolean run = true;

    public static void main(String[] args) {
        System.out.println("Welcome to Airline Reservation System");
        System.out.println("Please type 1 for First Class (OR) type 2 for Economy Class:");
        while(run){
            booking();
        }
    }
}