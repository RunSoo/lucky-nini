import java.util.*;
class Solution {
    static int cnt = 10001;
    public static class Coor {
        int r, c, dist;
        Coor(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int solution(int[][] maps) {
        
        bfs(maps);
        
        return cnt==10001?-1:cnt+1;
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public void bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Coor> queue = new LinkedList<>();
        queue.add(new Coor(0, 0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Coor top = queue.poll();
            // System.out.println(top.r+", "+top.c+", "+top.dist);
            if (top.r==n-1 && top.c==m-1) {
                cnt = top.dist;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nr = top.r+dr[d];
                int nc = top.c+dc[d];
                if (nr>=0 && nr<n && nc>=0 && nc<m && maps[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new Coor(nr, nc, top.dist+1));
                }
            }
        }
    }
}