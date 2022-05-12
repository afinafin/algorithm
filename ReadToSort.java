import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadToSort {

    public static void main(String[] args) {

        ArrayList<String> wording = new ArrayList<>();
        try {
            File myObj = new File("wordList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                wording.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //display array bfr sorted
//        System.out.println("Before:");
//        printArray(wording);

        //call method to sort elements in array
        quicksort(wording,0, wording.size()-1);

        //display array elements after sorted
        System.out.println("\nAfter");
        printArray(wording);
    }

    private static void quicksort(ArrayList<String> array, int lowIndex, int highIndex) {

        if(lowIndex>= highIndex) {
            return;
        }
        String pivot = array.get(highIndex);
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
 //       String first;

        while(leftPointer < rightPointer){
            //to increase the pointer in loop
           // first = array[leftPointer];

            while ((array.get(leftPointer).compareToIgnoreCase(array.get(highIndex)) <0)&& leftPointer < rightPointer) {
                leftPointer++;
                //it won't compare if put pivot instead of array[highIndex]
                //when the LP is greater than RP it will be automatically out of this loop
            }

            while((array.get(rightPointer).compareToIgnoreCase(array.get(highIndex)) >0) && leftPointer < rightPointer) {
                rightPointer--;
            }

            Collections.swap(array, leftPointer, rightPointer);
        }


        Collections.swap(array, leftPointer, highIndex);
        quicksort(array,lowIndex,leftPointer-1);
        quicksort(array, leftPointer + 1, highIndex);
    }

//    private static void swap(ArrayList<String> array, int index1, int index2) {
//        String temp = array.get(index1);
//        array.get(index1) = array[index2];
//        array[index2] = temp;
//
//    }

    private static void printArray(ArrayList<String> array) {
        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
