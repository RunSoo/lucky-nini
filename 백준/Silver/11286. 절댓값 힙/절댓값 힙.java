import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a)==Math.abs(b)) return a-b;
			else return Math.abs(a) - Math.abs(b);
		});
		for (int tc = 0; tc < N; tc++) {
			int x = Integer.parseInt(br.readLine());
			if (x!=0) pq.add(x);
			else {
				if (!pq.isEmpty()) System.out.println(pq.poll());
				else System.out.println(0);
			}
		}
	}
}