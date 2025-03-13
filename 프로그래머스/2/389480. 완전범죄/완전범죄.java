import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 40 * 3 * 2+1;
        int answer = INF;
        
        int[][] dp = new int[info.length + 1][m];
        for (int i=0; i<info.length+1; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        for (int i=1; i<info.length+1; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            for (int j=0; j<m; j++) {
                // A 도둑이 선택하는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+a);
                if (j+b < m) {
                    // B 도둑이 선택하는 경우
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }
        
        for (int j=0; j<m; j++) {
            answer = Math.min(answer, dp[info.length][j]);
        }
        
        return answer<n ? answer : -1;
    }
}