import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MergeSort {
    // Main method
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<Double>();
        ArrayList<Double> times = new ArrayList<Double>();
        String filePath = "resources/numbers.csv";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                numbers.add(Double.parseDouble(line.split(",")[0]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        for (int i = 0; i < 250; i++) {
            double startTime = System.currentTimeMillis();
            mergeSort(numbers);
            double endTime = System.currentTimeMillis();
            times.add(endTime - startTime);
        }
        Double averageTime = times.stream().mapToDouble(d -> d).average().orElse(0.0);
        System.out.println(averageTime);
    }

    // MergeSort method
    public static void mergeSort(ArrayList<Double> originalArray) {
        int arraySize = originalArray.size();
        if (arraySize < 2)
            return;
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

    // Merge method
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
}