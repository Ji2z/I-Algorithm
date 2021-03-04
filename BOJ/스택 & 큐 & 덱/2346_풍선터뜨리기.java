import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/2346
* @mem 14632kb
* @time 144ms
* @caution 덱으로 하면 메모리 초과가 나온다. ArrayDeque() <- 이걸로 하면 가능!!
*/

public class 풍선_터뜨리기_2346 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		// 풍선 개수
		int N = Integer.parseInt(br.readLine());

		// 풍선 받기
		List<Integer> balloonIdx = new ArrayList<>();
		int[] balloon = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			balloonIdx.add(n);
			balloon[n] = Integer.parseInt(st.nextToken());
		}
		
		int step = 0;
		int idx = 0;
		while(!balloonIdx.isEmpty()) {
			output.append(balloonIdx.get(idx)+1).append(" ");
			step = balloon[balloonIdx.get(idx)];
			balloonIdx.remove(idx);
			if(balloonIdx.isEmpty()) break;
			
			if(step>=0) {
				for (int i = 0; i < step-1; i++) {
					idx++;
				}
				if(idx >= balloonIdx.size()) idx %= balloonIdx.size();
			}else {
				step *= -1;
				for (int i = step; i > 0; i--) {
					idx--;
				}
				if(idx < 0) {
					while(idx<0) 
						idx += balloonIdx.size();	
				}
			}
		}
		
		System.out.println(output);
	}
}
