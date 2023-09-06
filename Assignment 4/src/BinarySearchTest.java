import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class performs a binary search on an array of 20 random integers in the 
 * range 1 to 100 to discover whether it contains an integer input from
 * the keyboard.
 *
 * @author Jing Hua Ye
 * @date Nov/6/2021
 * @version 1.0
 */
 class BinarySearchTest {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        //Task: create an array of 20 random integers between 1 and 100
         int[] data = new int[MAX_SIZE];
         for (int i = 0; i < data.length; i++)
             data[i] = 1 + generator.nextInt(100);

        //Task: which method should be used in Arrays class to make sure data in a sorted 
        //order
         Arrays.sort(data);

         //Task: display array as below: for example [-1, 10, 40, 30]
        //Hint: use the Arrays class, which method should we use to output data in a such 
        //format?
         System.out.printf("%s%n%n", Arrays.toString(data));

         //Task: repeatedly input an integer from user: -1 terminates the program
        //after reading an input of search key, we perform a binary search on 
        //data with this search key. Finally, print out the result of the binary search as the
        //sample outputs provided in the task specification
         int findInt = 0;
         while(findInt != -1) {
             // finding position of int
             int pos = binarySearch(data, findInt);

             // if for when position not found
             if(pos == -1) {
                 System.out.printf("%d was not found in array%n%n", findInt);
             }
             // if for when position found
             else {
                 System.out.printf("%d was found in position %d%n%n", findInt, pos);
             }

             // getting input from user
             System.out.print("Please enter an Integer value or (-1) to quit:");
             findInt = input.nextInt();
         }
     }
/* =============================================================================
                           HELPER METHODS 
   =============================================================================
 */
/**
 * To perform a binary search on an array of data
 *
 * @param data a static array of integers
 * @param searchKey the search key of performing the search
 * @return -1 if the searchKey is not found in the data, otherwise the position
 * of the searchKey in the data
 */
 private static int binarySearch(int[] data, int searchKey)
 {
     // lowest element of the search area
     int low = 0;
     // highest element of the search area
     int high = data.length -1;
     // middle element of the search area
     int middle = (low + high + 1) / 2;
     // return -1 if element not found
     int position = -1;
     System.out.println("Middle element is: " + data[middle]);
     // loop to search for element
     do {
         // print remaining elements to array
         System.out.print(remainingElements(data, low, high));

         // for loop to print spaces
         for(int i=0; i<middle; i++) {
             System.out.print(" ");
         }

         // print to indicate current middle element
         System.out.println(" * ");

         // if for when element is in middle position
         if(searchKey == data[middle]) {
             position = middle;
         }
         // if for when element is in lower than middle
         else if (searchKey < data[middle]) {
             // eliminate the higher elements
             high = middle - 1;
         }
         // else for when element is in higher than middle
         else {
             // eliminate the lower elements
             low = middle + 1;
         }

         // find current middle
         middle = (low + high + 1) / 2;

     }while((low <= high) && (position == -1));

     // return position of search key
     return position;
 }

    // method to output certain values in array
    private static String remainingElements(int[] data, int low, int high) {
        StringBuilder temp = new StringBuilder();

        temp.append(" ".repeat(Math.max(0, low)));

        // for loop to print elements going forward leftwards
        for(int i=low; i<=high; i++) {
            temp.append(data[i]).append(" ");
        }

        return String.format("%s%n", temp);
    }
  
  //you may need to consider defining some other helper methods to format the final outputs

/* ============================================================================
                            CLASS VARIABLES
   ============================================================================
 */
     //the maximum size of the static array
     private static final int MAX_SIZE = 20; 
}
