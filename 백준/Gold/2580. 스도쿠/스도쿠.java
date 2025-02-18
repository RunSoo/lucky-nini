import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static List<Point> zeroList;
	static boolean isFinished = false;

	public static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		zeroList = new ArrayList<>();

		for (int r = 0; r < 9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0)
					zeroList.add(new Point(r, c));
			}
		}

		checkPoint(0);

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void checkPoint(int idx) {
		if (idx == zeroList.size()) {
			isFinished = true;
			return;
		}

		Point p = zeroList.get(idx);
		boolean[] cantPut = new boolean[10];

		// 가로 줄 체크
		for (int c = 0; c < 9; c++) {
			cantPut[map[p.r][c]] = true;
		}

		// 세로 줄 체크
		for (int r = 0; r < 9; r++) {
			cantPut[map[r][p.c]] = true;
		}

		// 3x3 네모 체크
		int mr = (p.r / 3) * 3;
		int mc = (p.c / 3) * 3;
		for (int nr = mr; nr < mr + 3; nr++) {
			for (int nc = mc; nc < mc + 3; nc++) {
				cantPut[map[nr][nc]] = true;
			}
		}

		// 백트래킹 수행
		for (int i = 1; i <= 9; i++) {
			if (!cantPut[i]) {
				map[p.r][p.c] = i;
				checkPoint(idx + 1);
				if (isFinished)
					return;
				map[p.r][p.c] = 0;
			}
		}
	}
}