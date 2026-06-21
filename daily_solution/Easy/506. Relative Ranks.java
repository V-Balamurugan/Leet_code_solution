import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int s : score) {
            queue.offer(s);
        }

        HashMap<Integer, String> rank = new HashMap<>();

        int pos = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (pos == 1) {
                rank.put(curr, "Gold Medal");
            } else if (pos == 2) {
                rank.put(curr, "Silver Medal");
            } else if (pos == 3) {
                rank.put(curr, "Bronze Medal");
            } else {
                rank.put(curr, String.valueOf(pos));
            }

            pos++;
        }

        String[] answer = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            answer[i] = rank.get(score[i]);
        }

        return answer;
    }
}
