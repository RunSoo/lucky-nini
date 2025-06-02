import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 사람 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer>[] list = new ArrayList[201];

			Map<Integer, Integer> map = new HashMap<>();
			Queue<Integer> queue = new LinkedList<>();

			for (int t = 1; t <= N; t++) {
				int p = Integer.parseInt(st.nextToken());
				queue.add(p);
				if (!map.containsKey(p)) {
					map.put(p, 0);
					list[p] = new ArrayList<>();
				}

				list[p].add(t);
			}

			// 유효한 팀만 남기기
			Set<Integer> set = new HashSet<>(map.keySet());
			for (Integer s : set) {
				if (list[s].size() != 6) {
					map.remove(s);
				}
			}

			int[] cnt = new int[201];
			Map<Integer, Integer> fifth = new HashMap<>();
			int rank = 1;
			int min = Integer.MAX_VALUE;
			while (!queue.isEmpty()) {
				int top = queue.poll();

				if (map.containsKey(top)) {
					if (cnt[top] == 4) {
						fifth.put(top, rank);
					} else if (cnt[top] < 4) {
						map.put(top, map.get(top) + rank);

						if (cnt[top] == 3) {
							min = Math.min(map.get(top), min);
						}
					}
					cnt[top]++;
					rank++;
				}
			}

			set = new HashSet<>(map.keySet());
			for (Integer s : set) {
				if (map.get(s) != min)
					map.remove(s);
			}

			int min_team = -1;
			int min_val = Integer.MAX_VALUE;
			for (Integer m : map.keySet()) {
				if (min_val > fifth.get(m)) {
					min_val = fifth.get(m);
					min_team = m;
				}
			}

			sb.append(min_team).append("\n");
		}
		System.out.println(sb);
	}
}