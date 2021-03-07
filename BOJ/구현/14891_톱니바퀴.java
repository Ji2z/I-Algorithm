import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/14891
* @mem 11824kb
* @time 88ms
* @caution
*/

public class 14891_톱니바퀴 {
	
	static int[][] R;
	static List<Integer>[] circle;
	static int Rcnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		circle = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			circle[i] = new ArrayList<>();
			for (int j = 0; j < 8; j++) {
				circle[i].add(Integer.parseInt(s.charAt(j)+""));
			}
		}
		
		Rcnt = Integer.parseInt(br.readLine()); // 회전횟수
		R = new int[Rcnt][2]; // 톱니번호, 방향 => 1:시계, -1: 반시계
		for (int i = 0; i < Rcnt; i++) {
			st = new StringTokenizer(br.readLine()," ");
			R[i][0] = Integer.parseInt(st.nextToken())-1;
			R[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 초기 톱니 맞닿아 있는 부분 인덱스 : 2, 6
		for (int i = 0; i < Rcnt; i++) {
			int topni = R[i][0];
			int topniD = R[i][1];

			rotationL(topni, topniD*-1);
			rotationR(topni, topniD*-1);
			
			if(topniD==1) {
				int temp = circle[topni].get(7);
				circle[topni].remove(7);
				circle[topni].add(0, temp);
			}else {
				int temp = circle[topni].get(0);
				circle[topni].remove(0);
				circle[topni].add(temp);
			}
		}
		
		int answer = 0;
		for (int i = 0; i < 4; i++) {			
			if(circle[i].get(0) == 1) // S극
				answer += (int)(Math.pow(2, i));
		}
		
		System.out.println(answer);
	}// main
	
	static void rotationL(int topni, int topniD) {
		int topni6 = circle[topni].get(6);
		int topniL = topni-1;
		
		if(topniL>=0) {
			int topniL2 = circle[topniL].get(2);
		
			if(topniL2!=topni6) {
				rotationL(topniL, topniD*-1);
				if(topniD==1) {
					int temp = circle[topniL].get(7);
					circle[topniL].remove(7);
					circle[topniL].add(0, temp);
				}else {
					int temp = circle[topniL].get(0);
					circle[topniL].remove(0);
					circle[topniL].add(temp);
				}
			}else return;
		}else return;
	}
	
	static void rotationR(int topni, int topniD) {
		int topni2 = circle[topni].get(2);
		int topniR = topni+1;
		if(topniR<4) {
			int topniR6 = circle[topniR].get(6);
		
			if(topniR6!=topni2) {
				rotationR(topniR, topniD*-1);
				if(topniD==1) {
					int temp = circle[topniR].get(7);
					circle[topniR].remove(7);
					circle[topniR].add(0, temp);
				}else {
					int temp = circle[topniR].get(0);
					circle[topniR].remove(0);
					circle[topniR].add(temp);
				}
			}else return;
		}else return;
	}
}
