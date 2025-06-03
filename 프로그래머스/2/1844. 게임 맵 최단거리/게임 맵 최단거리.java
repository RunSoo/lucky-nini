import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        
        return answer;
    }
    
    static class Coor {
        int r, c;
        int cnt;
        Coor(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static int bfs(int[][] maps) {
        int R = maps.length;
        int C = maps[0].length;
        boolean[][] visited = new boolean[R][C];
        
        Queue<Coor> queue = new LinkedList<>();
        queue.add(new Coor(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Coor top = queue.poll();
            if (top.r == R-1 && top.c == C-1) return top.cnt;
            for (int d = 0; d < 4; d++) {
                int nr = top.r + dr[d];
                int nc = top.c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && maps[nr][nc] == 1) {
                    queue.add(new Coor(nr, nc, top.cnt + 1));
                    visited[nr][nc] = true;
                } 
            }
        }
        return -1;
    }
}