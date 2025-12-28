import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long min = 1;
        long max = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            if (canMake(n, times, mid)) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }

    public boolean canMake(int n, int[] times, long time) {
        long peop = 0;
        for (int t : times) {
            peop += time / t;
            if (peop >= n) return true;
        }
        return false;
    }
}
