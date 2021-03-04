package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 4.
* @author
* @see https://www.acmicpc.net/problem/2493
* @mem 83156kb
* @time 712ms
* @caution
*/

public class 탑_2493 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> tops = new Stack<>(); 
		st = new StringTokenizer(br.readLine()," ");

		for (int n = 1; n <= N; n++) {
			int h = Integer.parseInt(st.nextToken());
			while(!tops.isEmpty()) { // 확인 탑보다 높은 탑을 찾으면 출력후 반복문 탈출
				if(tops.peek()[1] >= h) { // 저장된 값이 확인값보다 높다면 저장되어있는 인덱스 출력 후
					output.append(tops.peek()[0]).append(" ");
					break;		// 브레이크로 팝 생략하고 반복문 탈출
				}
				tops.pop(); // 저장된 값(왼쪽 탑)이 확인 값(오른쪽 탑)보다 낮으면 버림 => 팝
			}
			if(tops.isEmpty()) {
				output.append("0 ");
			}
			tops.push(new int[]{n,h});
		}
		System.out.println(output);
	}
}
