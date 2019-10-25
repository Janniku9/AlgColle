package AlgsFromScript;

public class BinarySearch {
    //test
    public static void main(String[] args) {
        int [] A = {1, 3, 5, 7, 8, 13, 15, 16, 17, 18, 23, 26, 36, 38, 46, 47, 68};

        System.out.println(binarySearch(A, 13));
    }

    //binary Search
    public static boolean binarySearch (int [] A, int i) {
        int l = 0;
        int r = A.length-1;
        int m = (l+r)/2;

        while (l <= r) {
            if (A[m] == i)
                return true;
            else if (A[m] > i)
                r = m -1; //Important
            else if (A[m] < i)
                l = m + 1; //Important

            m = (r+l)/2;
        }
        return false;
    }

    public static int binarySearchAt (int [] A, int i) {
        int l = 0;
        int r = A.length-1;
        int m = (l+r)/2;

        while (l <= r) {
            if (A[m] == i)
                return m;
            else if (A[m] > i)
                r = m -1; //Important
            else if (A[m] < i)
                l = m + 1; //Important

            m = (r+l)/2;
        }
        return m;
    }

    public static boolean binarySearchInSubArray (int [] A, int i, int l, int r) {
        int m = (l+r)/2;

        while (l <= r) {
            if (A[m] == i) {
                return true;
            } else if (A[m] > i)
                r = m -1; //Important
            else
                l = m + 1; //Important

            m = (r+l)/2;
        }
        return false;
    }

    public static int binarySearchAtInSubArray (int [] A, int i, int l, int r) {
        int m = (l+r)/2;

        while (l <= r) {
            if (A[m] == i) {
                return m;
            } else if (A[m] > i)
                r = m -1; //Important
            else
                l = m + 1; //Important

            m = (r+l)/2;
        }
        return m;
    }
}
