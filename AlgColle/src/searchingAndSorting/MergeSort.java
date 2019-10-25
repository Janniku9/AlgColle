package searchingAndSorting;

public class MergeSort {

    public static int[] twoWayMergeSort (int [] A) {
        int m = A.length/2;

        twoWayMergeSortFromTo(A, 0, m);
        twoWayMergeSortFromTo(A, m+1, A.length-1);

        merge(A, 0, m, A.length-1);

        return A;
    }

    public static void twoWayMergeSortFromTo (int [] A, int l, int r) {
        if (l < r)  {
            int m = (l+r)/2;

            twoWayMergeSortFromTo(A, l, m);
            twoWayMergeSortFromTo(A, m+1, r);

            merge(A, l, m, r);
        }
    }

    public static void straightMergeSort (int [] B) {
        int [] A = new int[B.length+1];
        for (int i = 0; i < B.length; i++) {
            A[i+1] = B[i];
        }

        int length = 1;
        while (length < A.length) {
            int r = 0;

            while ((r+length) <A.length) {
                int l = r+1;
                int m = l+ length - 1;
                r = Math.min(m + length, A.length-1);
                merge(A, l, m , r);
            }
            length *= 2;
        }

        for (int i = 0; i < B.length; i++) {
            B[i] = A[i+1];
        }
    }

    public static int[] merge (int [] A, int l, int m, int r) {
        int [] B = new int[A.length];

        int i = l;
        int j = m+1;
        int k = l;

        while (i <=m && j <= r) {
            if (A[i] < A[j]) {
                B[k++] = A[i++];
            } else {
                B[k++] = A[j++];
            }
        }

        while (i<=m)
            B[k++] = A[i++];

        while (j <= r)
            B[k++] = A[j++];

        for (int n = l; n <= r; n++) {
            A[n] = B[n];
        }

        return A;
    }
}
