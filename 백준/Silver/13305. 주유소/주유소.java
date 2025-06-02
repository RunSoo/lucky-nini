import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] road = new int[N - 1]; // n번 ~ n+1번 도로 거리
		for (int r = 0; r < N - 1; r++) {
			road[r] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] price = new int[N]; // n번 가격
		int[] minPrice = new int[N];
		for (int p = 0; p < N; p++) {
			price[p] = Integer.parseInt(st.nextToken());
			if (p == 0) {
				minPrice[0] = price[0];
			} else {
				minPrice[p] = Math.min(minPrice[p - 1], price[p]);
			}
		}

		int totalPrice = 0;

		for (int l = N - 2; l >= 0; l--) {
			totalPrice += minPrice[l] * road[l];
		}

		System.out.println(totalPrice);
	}
}