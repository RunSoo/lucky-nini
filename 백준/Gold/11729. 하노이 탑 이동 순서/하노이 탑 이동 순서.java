import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] two = {{1, 3}};
		int cnt=1;
		int k=Integer.parseInt(br.readLine());

		while (cnt<k) {
			two = hanoi(two);
			cnt++;
		}
		for (int r=0; r<two.length; r++) {
			sb.append(two[r][0]).append(" ").append(two[r][1]).append("\n");
		}
		System.out.println(two.length);
		System.out.println(sb);
	}
	
	public static int[][] hanoi(int[][] two){
		int[][] next = new int[two.length*2+1][2];
		for (int r=0; r<two.length; r++) {
			for (int c=0; c<2; c++) {
				if (two[r][c]==2) next[r][c]=3;
				else if (two[r][c]==3) next[r][c]=2;
				else next[r][c]=1;
			}
		}
		next[two.length][0]=1;
		next[two.length][1]=3;
		for (int r=two.length+1; r<next.length; r++) {
			for (int c=0; c<2; c++) {
				if (two[r-two.length-1][c]==1) next[r][c]=2;
				else if (two[r-two.length-1][c]==2) next[r][c]=1;
				else next[r][c]=3;
			}
		}
		return next;
	}
	
	public static int[][] kthHanoi(int[][] two, int k) {
		if (two.length==(2*k+1)) {
			return two;
		} else {
			return kthHanoi(two, k);
		}
	}
}