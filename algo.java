import java.util.Random;

public class algo {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i =0; i< numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        //display array bfr sorted
        System.out.println("Before:");
        printArray(numbers);

        //call method to sort elements in array
        quicksort(numbers,0, numbers.length-1);

        //display array elements after sorted
        System.out.println("\nAfter");
        printArray(numbers);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if(lowIndex>= highIndex) {
            return;
        }
        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer< rightPointer){
            //to increase the pointer in loop
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
                //when the LP is greater than RP it will be automatically out of this loop
            }

            while(array[rightPointer] >= pivot && rightPointer > leftPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }


        swap(array, leftPointer, highIndex);
        quicksort(array,lowIndex,leftPointer-1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    private static void printArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
