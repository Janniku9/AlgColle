package searchingAndSorting;
import main.Util;

public class QuickSort {
    public static int[] quickSort(int[] A) {
        int pivot = A[Util.randomInt(A.length - 1)];

        pivot = partition(A, pivot, 0, A.length - 1);

        quickSort(A, 0, pivot);
        quickSort(A, pivot + 1, A.length-1);

        return A;
    }

    public static int[] quickSort(int[] A, int l, int r) {
        int pivot = A[l];
        pivot = partition(A, pivot, l, r);

        if (l < pivot)
            quickSort(A, l, pivot);

        if (r > pivot + 1)
            quickSort(A, pivot + 1, r);

        return A;
    }

    public static int partition(int[] A, int pivot, int l, int r) {
        int R =  r;

        while (l < r) {
            while (l < r && A[l] < pivot)
                l++;

            while (r > l && A[r] > pivot)
                r--;

            if (l < R) {
                Util.swap(A, l, r);
            }
        }
        return l;
    }
}
