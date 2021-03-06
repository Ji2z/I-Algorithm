import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/10157
* @mem 13304kb
* @time 100ms
* @caution
*/

public class 10157_자리배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int person = Integer.parseInt(br.readLine());
		
		if((C*R)<person) {
			System.out.println(0);
			System.exit(0);
		}
		// 좌석번호
		int x = 1;
		int y = 1;
		// 번호표
		int num = 1;
		
		int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}}; // 상, 우, 하, 좌
		int dir = 0;
		int[] size = {R,C};
		
		while(num<person) {
			for (int i = 0; i < size[dir%2]-1; i++) {
				x += delta[dir][0];
				y += delta[dir][1];
				num++;
				if(num==person) break;
			}
			if(num>(R+C)) {
				size[(dir+1)%2] = size[(dir+1)%2]-1;
			}
			dir++;
			if(dir==4) dir=0;
		}
		
		System.out.println(x+" "+y);
	}
}