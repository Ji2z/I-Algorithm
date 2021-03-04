import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/14696
* @mem 29208kb
* @time 304ms
* @caution
*/

public class 딱지놀이_14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int[] A = new int[5];
			int[] B = new int[5];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					if(i==0)
						A[Integer.parseInt(st.nextToken())]++;
					else
						B[Integer.parseInt(st.nextToken())]++;
				}
			}
			
			for (int i = 4; i > 0; i--) {
				if(A[i]>B[i]) {
					output.append("A\n");
					break;
				}else if(A[i]<B[i]) {
					output.append("B\n");
					break;
				}else if(i-1==0){
					output.append("D\n");
				}
			}
		}

		
		System.out.println(output);
	}	
}
