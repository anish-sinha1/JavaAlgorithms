import java.util.Arrays;

public class Inversions {
    public static void main(String[] args) {
        int[] arr = { 1, 20, 6, 4, 5 };

        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    private static int mergeAndCount(int[] array, int leftBound, int mid, int rightBound) {
        int[] left = Arrays.copyOfRange(array, leftBound, mid + 1);
        int[] right = Arrays.copyOfRange(array, mid + 1, rightBound + 1);
        int i = 0, j = 0, k = leftBound, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                array[k++] = left[i++];
            else {
                array[k++] = right[j++];
                swaps += (mid + 1) - (leftBound + i);
            }
        }
        while (i < left.length)
            array[k++] = left[i++];
        while (j < right.length)
            array[k++] = right[j++];
        return swaps;
    }

    private static int mergeSortAndCount(int[] array, int leftBound, int rightBound) {
        int count = 0;
        if (leftBound < rightBound) {
            int mid = (leftBound + rightBound) / 2;
            count += mergeSortAndCount(array, leftBound, mid);
            count += mergeSortAndCount(array, mid + 1, rightBound);
            count += mergeAndCount(array, leftBound, mid, rightBound);
        }
        return count;
    }
}