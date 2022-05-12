import java.util.Random;
import java.io.*;
import java.util.Arrays;

public class lexico {

    public static void main(String[] args) {

        String[] numbers
                = { "Harit","Girish", "Gritav", "Christ"};


        //display array bfr sorted
        System.out.println("Before:");
        printArray(numbers);

        //call method to sort elements in array
        quicksort(numbers,0, numbers.length-1);

        //display array elements after sorted
        System.out.println("\nAfter");
        printArray(numbers);
    }

    private static void quicksort(String[] array, int lowIndex, int highIndex) {

        if(lowIndex>= highIndex) {
            return;
        }
        String pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
 //       String first;

        while(leftPointer < rightPointer){
            //to increase the pointer in loop
           // first = array[leftPointer];

            while ((array[leftPointer].compareToIgnoreCase(array[highIndex]) <0)&& leftPointer < rightPointer) {
                leftPointer++;
                //it won't compare if put pivot instead of array[highIndex]
                //when the LP is greater than RP it will be automatically out of this loop
            }

            while((array[rightPointer].compareToIgnoreCase(array[highIndex]) >0) && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }


        swap(array, leftPointer, highIndex);
        quicksort(array,lowIndex,leftPointer-1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    private static void printArray(String[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
