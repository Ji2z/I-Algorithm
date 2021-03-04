package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 1.
* @author
* @see https://www.acmicpc.net/problem/1244
* @mem 14332kb
* @time 132ms
* @caution
*/

public class 스위치_켜고_끄기_1244 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		int[] bulb = new int[T+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<T; i++) {
			bulb[i+1] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(bulb)+"aaa");
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int button = Integer.parseInt(st.nextToken());
			
			if(gender == 1) { // 남자
				int m=1;
				do {
					bulb[button*m] = (bulb[button*m]==0?1:0);
					m++;
					//System.out.println(Arrays.toString(bulb)+"bbb");
				} while(button*m<T+1);
			} else { // 여자
				for(int j=0; button-j>0&&button+j<T+1; j++) {
					if(bulb[button-j]==bulb[button+j]) {
						bulb[button-j] = (bulb[button-j]==0?1:0);
						bulb[button+j] = bulb[button-j];
						//System.out.println(Arrays.toString(bulb)+"ccc");
					} else break;
				}
			}
		}
		
		for(int i=1; i<bulb.length; i++) {
			if(i%20 == 0) output.append(bulb[i]).append("\n");
			else output.append(bulb[i]).append(" ");
		}
		
		System.out.println(output);
		
	}
}
