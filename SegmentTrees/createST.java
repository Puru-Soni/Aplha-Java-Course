package SegmentTrees;

public class createST {

    static int[] tree;

    public int buildST(int[] val, int idx, int start, int end) {
        // base case
        if (start == end) {
            tree[idx] = val[start];
            return tree[idx];
        }

        // RR
        int mid = (start + end) / 2;
        buildST(val, idx * 2 + 1, start, mid);
        buildST(val, idx * 2 + 2, mid + 1, end);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        return tree[idx];
    }

    public int getSum(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || qi >= sj ) // no overlap
            return 0;
        else if (si >= qi && sj <= qj) // complete overlap
            return tree[i];
        else { // partial overlap
            int mid = (si + sj) / 2;
            int l = getSum(2 * i + 1, si, mid, qi, qj);
            int r = getSum(2 * i + 2, mid + 1, sj, qi, qj);
            return l + r;
        }
    }

    public static void main(String[] args) {
        int val[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // no of node -> 2*n-1
        // safe -> 4*n

        // construct -> O(n)
        // search -> O(logn)
        // update -> O(logn)

        createST q = new createST();
        tree = new int[4 * val.length];
        q.buildST(val, 0, 0, val.length - 1);
        // for (int i : tree)
        // System.out.print(i + " ");
        // System.out.println();

        System.out.println(q.getSum(0, 0, val.length - 1, 2, 5));
    }
}