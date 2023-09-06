import java.util.Arrays;
import java.security.SecureRandom;

/**
 * Sorting an array with selection Sort
 *
 * @author Jing Hua Ye
 * @date Nov/20/2021
 * @version 1.0
 */
class SelectionSortTest {
  /**
   * Sort an array using selection Sort
   * @param data an array of integers to be sorted
   */
   private static void selectionSort(int[] data)
   {

       // for loop to move the unsorted array
       for (int i = 0; i < data.length - 1; i++) {
           // initializing min
           int min = i;

           // finding the min element in the array
           for (int j = i + 1; j < data.length; j++) {
               if (data[j] < data[min]) {
                   min = j;
               }
           }
           // swap the min element
           swap(data, i, min);

           // print pass method
           printPass(data, i + 1, min);
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

  /**
   * To print a pass of the algorithm
   * @param data an array of integers to be sorted
   * @param pass the number of pass of the algorithm
   * @param index the index of the smallest data in the array
   */
   private static void printPass(int[] data, int pass, int index)
   {   System.out.printf("after pass %2d: ", pass);
       
       //output elements till selected item
       for (int i = 0; i < index; i++)
         System.out.printf("%d ", data[i]);
       
       //indicate swap
       System.out.printf("%d* ", data[index]);
       
       //finish outputting array
       for (int i = index + 1; i < data.length; i++)
         System.out.printf("%d  ", data[i]);
       
       //for alignment
       System.out.printf("%n               ");

       //indicate amount of array that's sorted
       for (int j = 0; j < pass; j++)
           System.out.print("-- ");
       System.out.println();
   }

   public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        //create unsorted array of 10 random integers
        int[] data = generator.ints(10, 10, 91).toArray();

        System.out.printf("Unsorted Array: %s%n%n", Arrays.toString(data));
        //sort array
        selectionSort(data);
        System.out.printf("%nSorted Array: %s%n", Arrays.toString(data));
  }
}
