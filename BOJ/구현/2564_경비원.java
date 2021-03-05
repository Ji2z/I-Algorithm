import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 6.
* @author Jin
* @see https://www.acmicpc.net/problem/2564
* @mem 11620kb
* @time 76ms
* @caution
*/

public class 2564_경비원 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken()); // 가로
		int C = Integer.parseInt(st.nextToken()); // 세로
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int myD = Integer.parseInt(st.nextToken());
		int myL = Integer.parseInt(st.nextToken());

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int sD = map[i][0];
			int sL = map[i][1];
			
			if((Math.abs(myD-sD)==1)&&!((myD==3&&sD==2)||(myD==2&&sD==3))) { // 동근이와 상점이 마주보고있을 때
				if(myD==1||myD==2) { // 북, 남쪽일 때
					answer += C;
					answer += Math.min(myL+sL, R-myL+R-sL);
				}else {
					answer += R;
					answer += Math.min(myL+sL, C-myL+C-sL);
				}
			}else if(Math.abs(myD-sD)==0){ // 동근이와 상점이 같은 방향에 있을 때
				answer += Math.abs(myL-sL);
			}else { // 동근이와 상점이 옆에 있을 때
				if(myD==1) {
					if(sD==3) {
						answer += (myL+sL);
					}else {
						answer += (R-myL+sL);
					}
				}else if(myD==3) {
					if(sD==1) {
						answer += (myL+sL);
					}else {
						answer += (C-myL+sL);
					}
				}else if(myD==2) {
					if(sD==3) {
						answer += (myL+C-sL);
					}else {
						answer += (R-myL+C-sL);
					}
				}else {
					if(sD==1) {
						answer += (myL+R-sL);
					}else {
						answer += (C-myL+R-sL);
					}
				}
			} // 동근이 상점 옆
		} // for
		System.out.println(answer);
	}
}