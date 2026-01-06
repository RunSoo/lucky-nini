import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] nums;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행의 개수
		M = Integer.parseInt(st.nextToken()); // 열의 개수
		nums = new int[N][M];
		visited = new boolean[N][M];
		for (int r=0; r<N; r++) {
			char[] charArr = br.readLine().toCharArray();
			for (int c=0; c<M; c++) {
				nums[r][c]=charArr[c]-'0';
			}
		}
		BFS();
		
		System.out.println(nums[N-1][M-1]);
	}
	private static void BFS() {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {0, 0});
		visited[0][0]=true;
		while (!queue.isEmpty()) {
			Integer[] top = queue.poll();
			if (top[0]==N-1 && top[1]==M-1) break;
			for (int dir=0; dir<4; dir++) {
				if (top[0]+dr[dir]>=0 && top[0]+dr[dir]<N && top[1]+dc[dir]>=0 && top[1]+dc[dir]<M && nums[top[0]+dr[dir]][top[1]+dc[dir]]==1 && !visited[top[0]+dr[dir]][top[1]+dc[dir]]) {
					queue.add(new Integer[] {top[0]+dr[dir], top[1]+dc[dir]});	
					visited[top[0]+dr[dir]][top[1]+dc[dir]]=true;
					nums[top[0]+dr[dir]][top[1]+dc[dir]]=nums[top[0]][top[1]]+1;
				}
			}
		}
	}
}