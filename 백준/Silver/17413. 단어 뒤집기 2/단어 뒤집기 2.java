import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		boolean isTag = false;
		for (int i=0; i<S.length(); i++) {
			if (!isTag && S.charAt(i)=='<') {
				isTag = true;
				result.append(sb.reverse().toString());
				result.append(S.charAt(i));
				sb = new StringBuilder();
			} else if (!isTag && S.charAt(i)==' '){
				result.append(sb.reverse().toString());
				result.append(" ");
				sb = new StringBuilder();
			}else if (!isTag) {
				sb.append(S.charAt(i));
			} else {
				if (S.charAt(i)=='>') isTag = false;
				result.append(S.charAt(i));
			}
		}
		result.append(sb.reverse().toString());
		System.out.println(result);
	}
}