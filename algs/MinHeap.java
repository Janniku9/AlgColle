package AlgsFromScript;

public class MinHeap {
    int [] A;
    int n;
    int position;

    public MinHeap(int n) {
        this.n = n;
        A = new int[n+1];
        position = 0;
        A[0] = Integer.MIN_VALUE;
    }

    public void insert(int x) {
        if(position==0){
            A[position++] = x;
            position = 2;
        } else {
            A[position++] = x;
            up();
        }
    }

    public void up () {
        int pos = position - 1;
        while (pos>0 && A[pos/2]>A[pos]) {
            Util.swap(A, pos, pos/2);
            pos = pos/2;
        }
    }

    public int extractMin () {
        int min = A[1];
        A[1] = A[position-1];
        A[position-1] = 0;
        position--;

        restore (1);

        return min;
    }

    private void restore(int i) {
        int left = 2*i;
        int right = (2*i)+1;
        int next = i;

        if (left <= position && A[left] < A[i]) {
            next = left;
        }

        if (right <= position && A[right] < A[next]) {
            next = right;
        }

        if (i != next) {
            Util.swap(A, i, next);
            restore(next);
        }
    }
}
