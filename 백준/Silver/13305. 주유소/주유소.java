import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] road = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] price = new int[N];
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		long total = 0;
		int min = price[0];
		for (int i = 0; i < N - 1; i++) {
			if (price[i] < min) {
				min = price[i];
			}
			total += (long) min * road[i];
		}

		System.out.println(total);
	}
}