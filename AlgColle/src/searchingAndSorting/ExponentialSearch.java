package searchingAndSorting;

public class ExponentialSearch {
    public static void main(String[] args) {
        int [] A = {1, 3, 5, 7, 8, 13, 15, 16, 17, 18, 23, 26, 36, 38, 46, 47, 68};

        System.out.println(exponentialSearch(A, 47));
    }

    public static boolean exponentialSearch (int A[], int i) {
        int r = 1;
        while (r < A.length && A[r] <= i)
            r = 2 * r;

        return BinarySearch.binarySearchInSubArray(A, i, r/2, Math.min(r, A.length - 1));
    }
}
