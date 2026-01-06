import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt = 0;
	
	static boolean canMove(int r, int c) {
		if (r>=0 && r < N && c>=0 && c<N) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r=0; r<N; r++) {
			String[] str = br.readLine().split("");
			for (int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (!visited[r][c] && map[r][c]==1) {
					cnt = 0;
					dfs(r, c);
					list.add(cnt);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for (Integer l : list) {
			System.out.println(l);
		}
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		
		for (int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (canMove(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);

			}
		}
	}
}