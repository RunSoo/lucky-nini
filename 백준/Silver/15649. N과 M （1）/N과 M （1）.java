import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] arr;
	static int[] output;
	static int N, M;
	
	static void Permutation(int depth, int len) {
		if (depth == len) {
			for (int i=0; i<M; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				Permutation(depth+1, len);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		visited = new boolean[N];
		output = new int[M];
		Permutation(0, M);
		
		System.out.println(sb);
	}
}