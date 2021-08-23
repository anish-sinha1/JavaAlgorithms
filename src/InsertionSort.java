import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class InsertionSort {
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
        insertionSort(list);
        double endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

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

    public static void print(ArrayList<Double> array) {
        int arrayLength = array.size();
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(array.get(i));
        }
    }
}
