package AlgsFromScript;

public class HeapSort {
    public static int [] heapSort (int [] A) {
        MaxHeap heap = initHeap(A);
        for (int i = A.length - 1; i >= 0 ; i--) {
           A[i] = heap.extractMax();
        }
        return A;
    }

    public static MaxHeap initHeap (int [] A) {
        MaxHeap heap = new MaxHeap (A.length);

        for (int i = 0; i < A.length; i++) {
            heap.insert(A[i]);
        }

        return heap;
    }
}
