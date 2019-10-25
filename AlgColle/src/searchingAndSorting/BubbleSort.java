package searchingAndSorting;
import main.Util;

public class BubbleSort {

    public static int[] bubbleSort (int A[]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j+1])
                    Util.swap(A, j, j+1);
            }
        }
        return A;
    }
}
