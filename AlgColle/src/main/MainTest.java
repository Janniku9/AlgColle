package main;
import graphAlgorithms.*;
import dataStructures.*;
import searchingAndSorting.*;
import dynamicProgramming.*;

public class MainTest {
    public static void main(String[] args) {
        testSortingAlgorithm();
        testSearch();
        testLAT();
        testPartition();
        testLGT();
        testMED();
        testSubsetSum();
        testKnapSack();
        testPrintTree();
        testStack();
        testQueue();
        testGraph();
        testDFS();
        testBFS();
        testInfiniteKnapsack();
    }

    public static void testSortingAlgorithm () {
        Util.Debug("SortingAlgorithm");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int A[] = {};
        A = Util.getRandomArray(20);
        A = Util.replaceDuplicates(A);

        Util.Info("Initial Array (isSorted:"+Util.isSorted(A)+"):");
        Util.printArray(A);

        //Sort
        HeapSort.heapSort(A);

        Util.Info("Sorted Array (isSorted:"+Util.isSorted(A)+")");
        Util.printArray(A);
    }

    public static void testSearch () {
        Util.Debug("Searching");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int A[] = {};
        A = Util.getRandomArray(20);
        HeapSort.heapSort(A);
        int [] B = Util.getRandomArray(10);

        Util.Info("Initial Array:");
        Util.printArray(A);

        //search
        for (int i = 0; i < B.length; i++) {
            boolean contains = BinarySearch.binarySearch(A, B[i]);

            if (contains)
                Util.Debug("Array contains " + B[i]);
            else
                Util.Error("Array doesn't contain " + B[i]);
        }
    }

    public static void testLAT () {
        Util.Debug("LAT");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int [] A = {1, 4, 3, 7, 2, 1};
        Util.Info("Array");
        Util.printArray(A);
        Util.Info("Length of LAT " + LAT.LATSquared(A));
        Util.printArray(LAT.getLATSquared(A));
    }

    public static void testPartition () {
        Util.Debug("Partition");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        //int [] A = Util.getRandomArray(20);
        int [] A = {73, 96, 96, 72, 68, 61, 86, 16, 80, 76, 44, 82, 11, 18, 45, 64, 47, 79, 30, 58};
        Util.Info("Initial Array");
        Util.printArray(A);
        int pivot = A[Util.randomInt(A.length)];
        Util.Info("Partition after: " + pivot);
        Util.Debug("l: " + QuickSort.partition(A, pivot, 0, A.length-1));
        Util.printArray(A);
    }

    public static void testLGT () {
        Util.Debug("LGT");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        String s1 = "brother";
        String s2 = "mother";

        Util.Info("LGT of " + s1 + " and " + s2 + " is: " + LGT.LGTLength(s1, s2));
        Util.Debug(LGT.LGT(s1, s2));

        Util.printTable(LGT.LGTDP(s1, s2));
    }

    public static void testMED () {
        Util.Debug("MED");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        String s1 = "tiger";
        String s2 = "ziege";

        Util.Debug("MED of " + s1 + " and " + s2 + " is: " + MED.MEDLength(s1, s2));

        Util.printTable(MED.MEDDP(s1, s2));
    }

    public static void testSubsetSum () {
        Util.Debug("SubSetSum");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int [] A = {1, 7, 3, 288, 17, 89, 34};
        int s = 133;

        Util.Info("Array:");
        Util.printArray(A);
        Util.Info("SubSet (is " + s + " Reachable: " + SubSetSum.isReachable(A, s) + ")");
        Util.printArray(SubSetSum.subSet(A,s));

        Util.printTable(SubSetSum.DP(A, s));
    }

    public static void testKnapSack () {
        Util.Debug("Knapsack");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int [][] A = Util.getRandomTable(2, 20);
        int W = Util.randomInt(100);

        Util.Info("Items:");
        Util.printTable(A);
        Util.Info("KnapsackSolution");
        Util.printTable(KnapSack.DP(A[0], A[1], W));
    }

    public static void testPrintTree () {
        Util.Debug("Tree");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int [] A = {1, 5, 6, 7, 8, 6, 4 ,5 ,3, 2, 5};

        Util.printTree(A);
    }

    public static void testStack () {
        Util.Debug("Stack");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(4);
        Util.Info(stack.top());
    }

    public static void testQueue () {
        Util.Debug("Queue");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(7);
        queue.dequeue();
        Util.Info(queue.front());
    }

    public static void testGraph () {
        Util.Debug("Graph");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        Graph g = new Graph(10);
        Util.printTable(g.ADJ);
        Util.printTable(g.calculateList(g.ADJ));
    }

    public static void testDFS () {
        Util.Debug("DFS");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int[][] A = {{0, 1, 1, 1, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 1, 0, 0, 0, 0},
                     {0, 0, 0, 1, 0, 0, 0, 0, 0},
                     {0, 1, 0, 0, 0, 1, 0, 0, 0},
                     {0, 0, 0, 0, 0, 1, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 1, 0},
                     {0, 0, 0, 1, 0, 0, 0, 0, 1},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        Graph g = new Graph(A);
        Util.printTable(g.calculateList(g.ADJ));

        Util.printArray(DFS.depthSearch(g, 0));
    }

    public static void testBFS () {
        Util.Debug("BFS");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int[][] A = {{0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        Graph g = new Graph(A);
        Util.printTable(g.calculateList(g.ADJ));

        Util.printArray(BFS.BFS(g, 0));
    }

    public static void testInfiniteKnapsack () {
        Util.Debug("InfiniteKnapsack");
        System.out.print(ConsoleColors.BLUE);
        Util.line(ConsoleColors.BLUE,100);
        System.out.println("");

        int [][] A = {{1, 4, 5, 7}, {1, 3, 4, 5}};
        int W = 8;

        Util.Info("Items:");
        Util.printTable(A);
        Util.Info("KnapsackSolution");
        Util.printTable(KnapSack.unlimitedDP(A[0], A[1], W));
    }
}
