import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class ReadFile {
    public static void main(String[] args) {

        int first=0, second=1;

        ArrayList<String> array = new ArrayList<>();
        array.clear();
        try {
            File myObj = new File("wordList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                boolean pass = data.matches("\\A\\p{ASCII}*\\z");
                if(pass) {
                    array.add(data);
                }
                //array.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Before sorting >> ");
        printArray(array);

        Collections.swap(array, array.size()-2,array.size()-1);

       System.out.println("After sorting >> ");
        printArray(array);
    }

    private static void printArray(ArrayList<String> array) {
        System.out.println(array);

    }

}
