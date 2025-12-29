import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] instructionG = new int[N][3];
		int[][] instructionB = new int[N][3];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			instructionG[i][0] = Integer.parseInt(st.nextToken());
			instructionB[i][0] = instructionG[i][0]==1?1:instructionG[i][0]==2?3:2;
			instructionG[i][1] = Integer.parseInt(st.nextToken());
			instructionB[i][2] = instructionG[i][0]==3?2-instructionG[i][1]:3-instructionG[i][1];
			instructionG[i][2] = Integer.parseInt(st.nextToken());
			instructionB[i][1] = instructionG[i][0]==3?2-instructionG[i][2]:3-instructionG[i][2];
		}
		
		int[] green = doWork(instructionG);
		int[] blue = doWork(instructionB);
		
		StringBuilder sb = new StringBuilder();
		sb.append(green[0]+blue[0]).append("\n").append(green[1]+blue[1]);
		System.out.println(sb);
		
	}
	
	public static void print(boolean[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int r=0; r<6; r++) {
			for (int c=0; c<4; c++) {
				if (map[r][c]) sb.append("O");
				else sb.append("X");
			}
			sb.append("\n");
		}
		System.out.println("===============================");
		System.out.println(sb);
	}
	
	public static void put(int t, int x, int y, boolean[][] map, int[] top) {
		switch (t) {
		case 1:
			map[--top[y]][y] = true;
			break;
		case 2:
			int minX = Math.min(top[y], top[y+1])-1;
			top[y] = minX;
			top[y+1] = minX;
			map[minX][y] = true;
			map[minX][y+1] = true;
			break;
		case 3:
			top[y]-=2;
			map[top[y]][y] = true;
			map[top[y]+1][y] = true;
			break;
		default:
		}
	}
	
	public static int point(boolean[][] map, int[] top) {
	    int score = 0;
	    boolean[] full = new boolean[6];

	    // 꽉 찬 줄 체크
	    for (int r = 0; r < 6; r++) {
	        boolean isFull = true;
	        for (int c = 0; c < 4; c++) {
	            if (!map[r][c]) {
	                isFull = false;
	                break;
	            }
	        }
	        if (isFull) {
	            full[r] = true;
	            score++;
	        }
	    }

	    // 아래에서부터 다시 쌓기
	    int write = 5;
	    for (int r = 5; r >= 0; r--) {
	        if (!full[r]) {
	            for (int c = 0; c < 4; c++) {
	                map[write][c] = map[r][c];
	            }
	            write--;
	        }
	    }

	    // 위쪽 비우기
	    for (int r = write; r >= 0; r--) {
	        for (int c = 0; c < 4; c++) {
	            map[r][c] = false;
	        }
	    }

	    // top 재계산
	    Arrays.fill(top, 6);
	    for (int c = 0; c < 4; c++) {
	        for (int r = 0; r < 6; r++) {
	            if (map[r][c]) {
	                top[c] = r;
	                break;
	            }
	        }
	    }

	    return score;
	}

	public static void remove(boolean[][] map, int[] top) {
	    int cnt = 0;

	    for (int c = 0; c < 4; c++) {
	        if (top[c] == 0) cnt = Math.max(cnt, 2);
	        else if (top[c] == 1) cnt = Math.max(cnt, 1);
	    }

	    if (cnt == 0) return;

	    // 아래에서부터 cnt만큼 밀기
	    for (int r = 5; r >= cnt; r--) {
	        for (int c = 0; c < 4; c++) {
	            map[r][c] = map[r - cnt][c];
	        }
	    }

	    // 위쪽 비우기
	    for (int r = 0; r < cnt; r++) {
	        for (int c = 0; c < 4; c++) {
	            map[r][c] = false;
	        }
	    }

	    // top 재계산
	    Arrays.fill(top, 6);
	    for (int c = 0; c < 4; c++) {
	        for (int r = 0; r < 6; r++) {
	            if (map[r][c]) {
	                top[c] = r;
	                break;
	            }
	        }
	    }
	}

	
	public static int[] doWork(int[][] inst) {
		int[] answer = new int[2];
		
		boolean[][] map = new boolean[6][4];
		int[] top = new int[4];
		for (int i=0; i<4; i++) {
			top[i] = 6; // 비어있음
		}
		int score = 0;
		
		
		for (int I=0; I<inst.length; I++) {
			int t = inst[I][0];
			int x = inst[I][1];
			int y = inst[I][2];
			
			put(t, x, y, map, top);
			
//			print(map);
//			System.out.println(Arrays.toString(top));
			
			score += point(map, top);
			
//			print(map);
//			System.out.println(Arrays.toString(top));
			
			remove(map, top);
			
//			print(map);
//			System.out.println(Arrays.toString(top));
		}
		
		answer[0] = score;
		for (int r=0; r<6; r++) {
			for (int c=0; c<4; c++) {
				if (map[r][c]) {
					answer[1]++;
				}
			}
		}
		
		return answer;
	}
}