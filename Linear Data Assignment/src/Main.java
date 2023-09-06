import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    spaceNumbers();
        System.out.println(" ");
        System.out.println("----------End of Method 1----------");
    barChart();
        System.out.println(" ");
        System.out.println("----------End of Method 2----------");
    }

    public static void spaceNumbers() {
        //scanner to take input from user
        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Enter a number with five digits: ");
        //storing input from user in int
        num = sc.nextInt();

        //ensuring number is 5 digits
        //if condition for printing the numbers with space between them
        if ((num >= 10000) && (num <= 99999)) {
            System.out.printf("%d  ", (num / 10000));
            System.out.printf("%d  ", (num / 1000) % 10);
            System.out.printf("%d  ", (num / 100) % 10);
            System.out.printf("%d  ", (num % 100) / 10);
            System.out.printf("%d  ", (num % 10));
        } else {
            System.out.println("Please enter number with ONLY 5 digits");
        }
    }

    public static void barChart() {
        //scanner to take input from user
        Scanner sc = new Scanner(System.in);

        //making a number array with 5 max integers
        int[] numberArray = new int[5];

        //for loop to go through the array
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter any number: ");

            //storing user input in int
            int num = sc.nextInt();

            //comparing the array with user input
            numberArray[i] = num;
        }
        //separate loop to generate asterisks
        for (int i = 0; i < 5; i++) {

            //comparing the first loop with the array to print the amount of asterisks in the number array
            for (int j = 0; j < numberArray[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

