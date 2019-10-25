package searchingAndSorting;

public class InsertionSort {

    public static int [] insertionSort (int [] A) {
        for (int i = 1; i < A.length; i++) {
            int target = BinarySearch.binarySearchAtInSubArray(A, A[i],0, i-1);
            int b = A[i];


            if (A[target] < A[i]) {
                target++;
            }
            for (int j = i; j > target ; j--) {
                    A[j] = A[j-1];
            }

            A[target] = b;
        }
        return A;
    }
}
