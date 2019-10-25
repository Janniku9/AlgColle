package AlgsFromScript;

public class LinearSearch {
    public static void main(String[] args) {
        Integer [] A = {3, 56, 433, 2, 3,4, 5, 4456 ,5,6, 667, 5,4,3, 567 ,332, 4556 ,6677 ,4433};
        String []  B = {"gay", "nup", "yosh", "ez", "gg", "wp", "sweg"};

        System.out.println(linearSearch(A, 56));
        System.out.println(linearSearch(B, "sweg"));
    }

    public static <T> boolean linearSearch (T [] A, T i) {
        for (int j = 0; j < A.length; j++) {
            if (A[j].equals(i))
                return true;
        }

        return false;
    }
}
