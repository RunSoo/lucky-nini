class Solution {
    public static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        makeNum(0, 0, visited, target, numbers);
        
        return cnt;
    }
    
    public void makeNum(int sum, int idx, boolean[] visited, int target, int[] numbers) {
        if (idx == visited.length) {
            if (sum == target) cnt++;
            return;
        }
        visited[idx] = true;
        makeNum(sum + numbers[idx], idx+1, visited, target, numbers);
        makeNum(sum - numbers[idx], idx+1, visited, target, numbers);
    }
}