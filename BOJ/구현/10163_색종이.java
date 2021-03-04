import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/10163
* @mem 14856kb
* @time 140ms
* @caution
*/

public class 색종이_10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 색종이 개수
		int[] paper = new int[T];
		int[][]map = new int[101][101];
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int i = 100 - Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			paper[t] = w*h;
			for (int r = i; r > i-h; r--) {
				for (int c = j; c < j+w; c++) {
					if(map[r][c] == 0) 
						map[r][c] = t+1;				
					else {
						int num = map[r][c];
						paper[num-1]--;
						map[r][c] = t+1;
					}
				}
			}
		}

		for (int i = 0; i < T; i++) {
			output.append(paper[i]).append("\n");
		}
		
		System.out.println(output);
	}
}
