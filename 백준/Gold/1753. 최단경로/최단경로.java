import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	
	static class Node implements Comparable<Node>{
		
		int node, cost;
		Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine())-1;
		
		int INF = 10*300000;
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		for (int i=0; i<V; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())-1).add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		dist[K] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));
		boolean[] visited = new boolean[V];
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.node]) continue;
			visited[cur.node] = true;
			
			for (Node next : list.get(cur.node)) {
				if (dist[cur.node] + next.cost < dist[next.node]) {
					dist[next.node] = dist[cur.node] + next.cost;
					pq.offer(new Node(next.node, dist[next.node]));
				}
			}
		}
		
		for (int i=0; i<V; i++) {
			if (dist[i]!=INF) System.out.println(dist[i]);
			else System.out.println("INF");
		}
	}
}