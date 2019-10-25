package searchingAndSorting;
import main.Util;

public class SelectionSort {

    public static int [] selectionSort (int[] A) {
        for (int i = 0; i < A.length -1; i++) {
            if (Util.findMinInSubArray(A, i, A.length-1) != A[i] && Util.findMinInAtSubArray(A, i, A.length-1) != i)
                Util.swap(A, i, Util.findMinInAtSubArray(A, i, A.length-1));
        }
        return A;
    }
}
