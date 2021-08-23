//* Extremely efficient sorting algorithm.
//* Performs mergeSort on large n but insertionSort on small n where it is more efficient.
//* This algorithm is approximately twice as a fast as a plain mergeSort algorithm.
//* Over a test of 250 trials of sorting 1000 numbers between 0 and 100000, this algorithm 
//* took approximately 0.328 seconds. In comparison, plain mergeSort took about 0.7 seconds. 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CombinedSort {
    // constants
    public static final int THRESHOLD = 43; // Threshold for which insertionSort beats mergeSort
    // main method

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        String filePath = "resources/largeDataset.csv";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                list.add(Double.parseDouble(line.split(",")[0]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        double startTime = System.currentTimeMillis();
        mergeSort(list);
        double endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    // merge
    public static ArrayList<Double> merge(ArrayList<Double> left, ArrayList<Double> right,
            ArrayList<Double> unsortedNumbers) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                unsortedNumbers.set(k, left.get(i));
                i++;
            } else {
                unsortedNumbers.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()) {
            unsortedNumbers.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            unsortedNumbers.set(k, right.get(j));
            j++;
            k++;
        }
        return unsortedNumbers;
    }

    // mergeSort
    public static void mergeSort(ArrayList<Double> originalArray) {
        int arraySize = originalArray.size();
        if (arraySize < THRESHOLD)
            insertionSort(originalArray);
        else {
            int mid = (int) Math.floor(arraySize / 2);
            ArrayList<Double> left = new ArrayList<Double>(mid);
            ArrayList<Double> right = new ArrayList<Double>(arraySize - mid);
            for (int i = 0; i < mid; i++) {
                left.add(originalArray.get(i));
            }
            for (int j = mid; j < arraySize; j++) {
                right.add(originalArray.get(j));
            }
            mergeSort(left);
            mergeSort(right);
            merge(left, right, originalArray);
        }
    }

    // insertionSort
    public static ArrayList<Double> insertionSort(ArrayList<Double> array) {
        int arrayLength = array.size();
        for (int i = 0; i < arrayLength; i++) {
            Double key = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, key);
        }
        return array;
    }

    // print
    public static void print(ArrayList<Double> array) {
        int arrayLength = array.size();
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(array.get(i));
        }
    }
}