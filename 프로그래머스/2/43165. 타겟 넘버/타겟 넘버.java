import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // 모든 방법의 수 => bfs
        return bfs(numbers, target);
    }
    
    public int bfs(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int depth = 0;
        queue.add(0);
        while (depth<numbers.length) {
            int len = queue.size();
            for (int i=0; i<len; i++) {
                int top = queue.poll();
                queue.add(top+numbers[depth]);
                queue.add(top-numbers[depth]);
            }
            depth++;
        }
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            if (queue.poll()==target) {
                cnt++;
            }
        }
        return cnt;
    }
}