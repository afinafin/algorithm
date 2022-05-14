// Java implementation of QuickSort

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuickSort {
    // Driver Code
    public static void main(String[] args)
    {
        ArrayList<String> word = new ArrayList<>();
        try {
            //read file into ArrayList
            File myObj = new File("wordList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                boolean pass = data.matches("\\A\\p{ASCII}*\\z");
                if(pass) {
                    word.add(data);
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        quickSort(word, 0, word.size()-1);
        System.out.println("Sorted words in Sorted.txt file");
        printArray(word);
    }

    private static void quickSort(ArrayList<String> arr, int low, int high)
    {
        if (low < high)
        {
            //current index of element that already at the right place(sorted)
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            //recursively sort elements on the right side(more than a sorted element)
            //and left side(less than a sorted element) of the pivot
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }



    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    private static int partition(ArrayList<String> arr, int low, int high)
    {

        // choose last element at the highest index in a single partition as pivot
        String pivot = arr.get(high);

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is lexicographically smaller than the pivot
            if (arr.get(j).compareToIgnoreCase(pivot)<0)
            {

                // Increment index of smaller element
                i++;
                //use collections function to swap between two desired elements
                Collections.swap(arr, i, j);
            }
        }
        //use collections function to swap between two desired elements
        Collections.swap(arr, i + 1, high);
        return (i + 1);
    }



    // Function to print an array
     private static void printArray(ArrayList<String> arr)
    {
        try{
            PrintWriter writer = new PrintWriter("Sorted.txt", StandardCharsets.UTF_8);
            for(int i=0; i<arr.size(); i++)
            {
                writer.println(arr.get(i));
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


