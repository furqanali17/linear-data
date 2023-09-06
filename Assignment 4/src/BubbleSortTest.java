import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Sorting an array into ascending order with bubble Sort
 *
 * @author Jing Hua Ye
 * @date Nov/20/2021
 * @version 1.0
 */
public class BubbleSortTest {

 /**
  * Sort elements of array with bubble sort
  * @param data an array of unsorted integers
  */
   private static void bubbleSort(int[] data)
   {
       // initializing array to use in while loop
       int arr = data.length;

       // while loop to go through array
       while (arr != 0) {
           int j = 0;
           // second while loop which compares first two elements
           while (j != arr - 1) {
               // if condition for when one of element is greater than other
               if (data[j + 1] < data[j]) {
                   // performing swap method
                   swap(data, j, j + 1);
               }
               j++;
           }
           arr--;
       }
   }

  /**
   * Swap values in two elements
   * @param data an array of integers to be sorted
   * @param first the first element in the array to be swapped
   * @param second the second element in the array to be swapped
   */
   private static void swap(int[] data, int first, int second)
   {  //store first in temporary variable
      int temporary = data[first];

      //replace first with second
      data[first] = data[second];

      //put temporary in second
      data[second] = temporary;  
   } 

   public static void main(String[] args) {
      SecureRandom generator = new SecureRandom();

      // create unordered array of 10 random ints
      int[] data = generator.ints(10, 10, 91).toArray(); 

      System.out.printf("Unsorted array: %s%n", Arrays.toString(data));
      bubbleSort(data); // sort array
      System.out.printf("Sorted array: %s%n", Arrays.toString(data));
   }
}
