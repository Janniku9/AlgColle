package AlgsFromScript;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.management.monitor.GaugeMonitor;

public class Util {
    public static int[] swap (int[] A, int i, int j) {
        int z = A[i];
        A[i] = A[j];
        A[j] = z;

        return A;
    }

    public static boolean isSorted (int [] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i+1])
                return false;
        }
        return true;
    }

    public static int findMax (int [] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    public static int findMaxAt (int [] A) {
        int max = A[0];
        int at = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                at = i;
            }
        }
        return at;
    }

    public static int findMaxInSubArray (int [] A, int x, int y) {
        int max = A[x];
        for (int i = x+1; i < y+1; i++) {
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    public static int findMaxAtInSubArray (int [] A, int x, int y) {
        int max = A[x];
        int at = x;
        for (int i = x+1; i < y + 1; i++) {
            if (A[i] > max) {
                max = A[i];
                at = i;
            }
        }
        return at;
    }

    public static int findMin (int [] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min)
                min = A[i];
        }
        return min;
    }

    public static int findMinAt (int [] A) {
        int min = A[0];
        int at = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
                at = i;
            }
        }
        return at;
    }

    public static int findMinInSubArray (int [] A, int x, int y) {
        int min = A[x];
        for (int i = x+1; i < y + 1; i++) {
            if (A[i] < min)
                min = A[i];
        }
        return min;
    }

    public static int findMinInAtSubArray (int [] A, int x, int y) {
        int min = A[x];
        int at = x;
        for (int i = x+1; i < y + 1; i++) {
            if (A[i] < min) {
                min = A[i];
                at = i;
            }
        }
        return at;
    }

    public static int[] getRandomArray (int n) {
        int A[] = new int [n];
        for (int i = 0; i < A.length; i++) {
            A[i] = randomInt(100);
        }

        return A;
    }

    public static int [] getRandomArray () {
        int A[] = new int [randomInt(100)];
        for (int i = 0; i < A.length; i++) {
            A[i] = randomInt(100);
        }

        return A;
    }

    public static <T> void printArray (T [] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println("\n");
    }

    public static void printArray (int [] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(ConsoleColors.RED + A[i] + ConsoleColors.RESET + ", ");
        }
        System.out.println("\n");
    }

    public static <T> void printTable (T [][] A) {
        System.out.print("       ");
        for (int i = 0; i < A[0].length; i++) {
            System.out.print(extendString(String.valueOf(i), 6));
        }

        for (int i = 0; i < A.length; i++) {
            printLine(A[0].length);
            System.out.print(extendString(String.valueOf(i), 5) + " ");
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(String.valueOf("|" + extendString(String .valueOf(A[i][j]), 5)));
            }
            System.out.print("|");
        }
        printLine(A[0].length);
    }

    public static void printTable (int [][] A) {
        System.out.print("       ");
        for (int i = 0; i < A[0].length; i++) {
            System.out.print(extendString(String.valueOf(i), 6));
        }

        for (int i = 0; i < A.length; i++) {
            printLine(A[i].length);
            System.out.print(extendString(String.valueOf(i), 5) + " ");
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(String.valueOf("¦" + ConsoleColors.RED +  extendString(String .valueOf(A[i][j]), 5) + ConsoleColors.RESET));
            }
            System.out.print("¦");
        }
        printLine(A[0].length);
    }

    public static void printTable (Boolean [][] A) {
        System.out.print("       ");
        for (int i = 0; i < A[0].length; i++) {
            System.out.print(extendString(String.valueOf(i), 6));
        }

        for (int i = 0; i < A.length; i++) {
            printLine(A[i].length);
            System.out.print(extendString(String.valueOf(i), 5) + " ");
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j])
                    System.out.print(String.valueOf("¦" + ConsoleColors.GREEN +  extendString("T", 5) + ConsoleColors.RESET));
                else
                    System.out.print(String.valueOf("¦" + ConsoleColors.RED +  extendString("F", 5) + ConsoleColors.RESET));
            }
            System.out.print("¦");
        }
        printLine(A[0].length);
    }

    public static void printLine (int amount) {
        String line = "      +";
        for (int i = 0; i < amount; i++) {
            line+="-----+";
        }

        System.out.println("\n" + line);
    }

    public static String extendString (String in, int n) {
         while (in.length() < n) {
             if (in.length()%2==0)
                 in = " " + in;
             else
                 in = in + " ";
         }

         return in;
    }

    public static int randomInt (int bounds) {
        return (int)(Math.random() * bounds);
    }

    public static int[] replaceDuplicates (int [] A) {
        while (hasDuplicates(A)) {
            A = getRandomArray(A.length);
        }
        return A;
    }

    public static boolean hasDuplicates (int [] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j && A[i] == A[j])
                    return true;
            }
        }
        return false;
    }

    public static int [][] getRandomTable (int n, int m) {
        int [][] res = new int [n][m];
        for (int i = 0; i < n; i++) {
            res[i] = getRandomArray(m);
        }

        return res;
    }

    //IMPORTANT start with 1!
    public static void printTree (int [] tree) {
        int h = (int) Math.ceil(Math.log(tree.length))+1;

        int[][] buffer = new int[h][(int)Math.ceil(Math.pow(2, h))];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[0].length; j++) {
                buffer[i][j] = Integer.MIN_VALUE;
            }
        }

        recursiveInit(buffer, tree, 1, buffer[0].length/2-1, 0, buffer[0].length/4);
        printBuffer(buffer);
    }

    static void recursiveInit (int [][] buffer, int [] A, int current, int x, int y, int h) {
        if (current <  A.length && x >= 0 && x < buffer[0].length && y < buffer.length) {
            buffer[y][x] = A[current];
            if (h > 0) {
                recursiveInit(buffer, A, current * 2, x - h, y + 1, h / 2);
                recursiveInit(buffer, A, current * 2 + 1, x + h, y + 1, h / 2);
            }
        }
    }

    static void printBuffer (int [][] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(extendString(String.valueOf(i), 5) + " |");
            for (int j = 0; j < buffer[0].length; j++) {
                if (buffer[i][j] == Integer.MIN_VALUE)
                    System.out.print("       ");
                else
                    System.out.print("|"+extendString(String.valueOf(buffer[i][j]), 5)+"|");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static void printBool (boolean bool) {
        if (bool) {
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + bool + ConsoleColors.RESET);
        } else
            System.out.println(ConsoleColors.RED + bool + ConsoleColors.RESET);
    }

    public static void Info (String s) {
        System.out.println(ConsoleColors.YELLOW + s + ConsoleColors.RESET);
    }

    public static void Info (int s) {
        System.out.println(ConsoleColors.YELLOW + s + ConsoleColors.RESET);
    }

    public static void Debug (String s) {
        System.out.println(ConsoleColors.BLUE + s + ConsoleColors.RESET);
    }

    public static void Debug (int s) {
        System.out.println(ConsoleColors.BLUE + s + ConsoleColors.RESET);
    }

    public static void Error (String s) {
        System.out.println(ConsoleColors.RED + s + ConsoleColors.RESET);
    }

    public static void line (String color, int amount) {
        String str = "";
        for (int i = 0; i < amount; i++) {
            str+="-";
        }

        System.out.println(color + str + ConsoleColors.RESET);
    }
}
