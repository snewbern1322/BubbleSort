//import required tools/packages
import java.util.Random;
import java.io.*;

public class BubbleSortAssignment {

    //Generate array of random integers (0-100)
    public static int[] spawnRandomArray(int arrayLength) {
        int[] randomArray = new int[arrayLength];
        Random rand = new Random(); //random function

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = rand.nextInt(101); //generate random integers
        }
        return randomArray; //returns random array

    }

    //write int array to file one at a time
    public static void arrayToFile(int[] array, String arrayfile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arrayfile))) {
            for (int number : array) {
                writer.println(number);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

            
    }

    //read integers from file
    public static int[] readFileArray(String arrayfile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arrayfile))){
        String line;
        int[] array = new int[0];
        int index = 0;

        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line);

            if (index >= array.length) {
                int[] newArray = new int[array.length +1];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }

            array[index] = number; //store read integer in array
            index++;
            }
        
            return array;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    
    }
    
    //sort integer array ascending order
    //bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i< n;i++) {
                if (array[i-1] > array[i]) {
                    //swap array[i-1] and array[i]
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        }while (swapped);
    }
    public static void main(String[] args){
        //main function
    }
}
