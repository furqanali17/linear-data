import java.util.Arrays;
import java.security.SecureRandom;

/**
 * Sorting an array with selection Sort
 *
 * @author Jing Hua Ye
 * @date Nov/20/2021
 * @version 1.0
 */
class InsertionSortTest {
  /**
   * Sort an array using selection Sort
   * @param data an array of integers to be sorted
   */
   private static void insertionSort(int[] data)
   {
       // for loop to go through all elements of the array
       for(int i = 1; i < data.length; i++) {
           // insertion value
           int insert = data[i];
           // position to place element
           int newPos = i;

           // while loop to place new element
           while(newPos > 0 && data[newPos -1] > insert) {
               // shift element right one slot
               data[newPos] = data[newPos -1];
               newPos--;
           }

           // place the inserted element
           data[newPos] = insert;
           // print pass method
           printPass(data, i, newPos);
       }
   }

  /**
   * To print a pass of the algorithm
   * @param data an array of integers to be sorted
   * @param pass the number of pass of the algorithm
   * @param index the index of the smallest data in the array
   */
   private static void printPass(int[] data, int pass, int index)
   {   System.out.printf("after pass %2d: ", pass);
       
       //output elements till swapped item
       for (int i = 0; i < index; i++)
         System.out.printf("%d ", data[i]);
       
       //indicate swap
       System.out.printf("%d* ", data[index]);
       
       //finish outputting array
       for (int i = index + 1; i < data.length; i++)
         System.out.printf("%d ", data[i]);
       
       //for alignment
       System.out.printf("%n               ");

       //indicate amount of array that's sorted
       for (int i = 0; i <= pass; i++)
          if (i <= index)
             System.out.print("-- ");
          else if (i == index + 1)
             System.out.print(" -- ");
          else
             System.out.print("-- ");
       System.out.println();
   }

   public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        //create unsorted array of 10 random integers
        int[] data = generator.ints(10, 10, 91).toArray();

        System.out.printf("Unsorted Array: %s%n%n", Arrays.toString(data));
        //sort array
        insertionSort(data);
        System.out.printf("%nSorted Array: %s%n", Arrays.toString(data));
  }
}
