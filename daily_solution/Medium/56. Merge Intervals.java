class Solution {

    static int[][] sort(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        return intervals;
    }

    public int[][] merge(int[][] intervals) {
        System.gc();
        if (intervals.length <= 1)
            return intervals;

        intervals = sort(intervals);

        int[][] result = new int[intervals.length][2];
        int index = 0;

        result[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (result[index][1] >= intervals[i][0]) {
                result[index][1] = Math.max(result[index][1], intervals[i][1]);
            } else {
                index++;
                result[index] = intervals[i];
            }
        }

        int[][] ans = new int[index + 1][2];

        for (int i = 0; i <= index; i++) {
            ans[i] = result[i];
        }

        return ans;
    }
}
