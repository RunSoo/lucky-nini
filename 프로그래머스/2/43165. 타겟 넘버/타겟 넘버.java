class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return cnt;
    }
    
    public static void dfs(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(idx + 1, sum + numbers[idx], numbers, target);
        dfs(idx + 1, sum - numbers[idx], numbers, target);
    }
}