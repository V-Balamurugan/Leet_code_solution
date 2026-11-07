import java.util.*;

class Solution {

    int[] tree, servers;
    int n;

    int best(int a, int b) {
        if (a == -1) return b;
        if (b == -1) return a;

        if (servers[a] != servers[b])
            return servers[a] < servers[b] ? a : b;

        return Math.min(a, b);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, val);
        else
            update(node * 2 + 1, mid + 1, r, idx, val);

        tree[node] = best(tree[node * 2], tree[node * 2 + 1]);
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = l;
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = best(tree[node * 2], tree[node * 2 + 1]);
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        this.servers = servers;
        n = servers.length;

        tree = new int[4 * n];
        build(1, 0, n - 1);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ?
                Long.compare(a[0], b[0]) :
                a[1] != b[1] ?
                Long.compare(a[1], b[1]) :
                Long.compare(a[2], b[2])
        );

        int[] ans = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {

            time = Math.max(time, i);

            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                int idx = (int) pq.poll()[2];
                update(1, 0, n - 1, idx, idx);
            }

            if (tree[1] == -1) {
                time = pq.peek()[0];

                while (!pq.isEmpty() && pq.peek()[0] <= time) {
                    int idx = (int) pq.poll()[2];
                    update(1, 0, n - 1, idx, idx);
                }
            }

            int idx = tree[1];
            ans[i] = idx;

            update(1, 0, n - 1, idx, -1);

            pq.offer(new long[]{time + tasks[i], servers[idx], idx});
        }

        return ans;
    }
}
