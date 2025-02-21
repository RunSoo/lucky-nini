import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class UnionFind {
		int[] parent, rank;
		int N;

		UnionFind(int N) {
			this.N = N;
			this.parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			this.rank = new int[N];
		}

		int find(int idx) {
			if (parent[idx] != idx) {
				parent[idx] = find(parent[idx]);
			}
			return parent[idx];
		}

		void union(int idx1, int idx2) {
			int root1 = find(idx1);
			int root2 = find(idx2);

			if (root1 != root2) {
				if (rank[root1] > rank[root2]) {
					parent[root2] = root1;
				} else if (rank[root2] > rank[root1]) {
					parent[root1] = root2;
				} else {
					parent[root2] = root1;
					rank[root1]++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		UnionFind uf = new UnionFind(N + 1);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int instruction = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (instruction == 0) {
				uf.union(a, b);
			} else if (instruction == 1) {
				if (uf.find(a) == uf.find(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}
}