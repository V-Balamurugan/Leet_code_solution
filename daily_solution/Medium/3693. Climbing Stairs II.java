
class Solution {

    static int Min(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        else if (b <= c) {
            return b;
        }
        else {
            return c;
        }
    }

    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            int one = dp[i - 1] + 1;
            int two = Integer.MAX_VALUE;
            int three = Integer.MAX_VALUE;

            if (i >= 2) {
                two = dp[i - 2] + 4;
            }

            if (i >= 3) {
                three = dp[i - 3] + 9;
            }

            dp[i] = Min(one, two, three) + costs[i - 1];
        }

        return dp[n];
    }
}
