package SegmentTrees;

public class max_minQuery {
    static int[] tree;

    // create
    public static void createTree(int[] val, int s, int e, int i) {

        // Base Case
        if (s == e) {
            tree[i] = val[s];
            return;
        }

        int mid = (s + e) / 2;
        createTree(val, s, mid, i * 2 + 1);
        createTree(val, mid + 1, e, i * 2 + 2);
        tree[i] = Math.max(tree[i * 2 + 1], tree[i * 2 + 2]);
    }

    // search
    public static int getVal(int i, int s, int e, int qi, int qj) {
        if (qi > e || qj < s)
            return Integer.MIN_VALUE;
        else if (qi <= s && e <= qj)
            return tree[i];
        else {
            int mid = (s + e) / 2;
            int left = getVal(i * 2 + 1, s, mid, qi, qj);
            int right = getVal(i * 2 + 2, mid + 1, e, qi, qj);
            return Math.max(left, right);
        }
    }

    // update
    public static void getUpdate(int i, int si, int sj, int id, int num) {
        if (id < si || sj < id)
            return;
        if (si == sj) {
            tree[i] = num;
            return;
        }
        tree[i] = Math.max(tree[i], num);
        int mid = (si + sj) / 2;
        getUpdate(i * 2 + 1, si, mid, id, num);
        getUpdate(i * 2 + 2, mid + 1, sj, id, num);
    }

    public static void main(String[] args) {
        int[] val = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = val.length;
        tree = new int[4 * n];

        createTree(val, 0, n - 1, 0);
        getUpdate(0, 0, n - 1, 2, 20);

        int ans = getVal(0, 0, n - 1, 1, 3);
        System.out.println(ans);

        // for min function ST change max -> min
    }
}
