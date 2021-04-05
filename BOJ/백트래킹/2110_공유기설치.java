import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/2110
* @mem 21552kb
* @time 224ms
* @caution S1 이분탐색을 사용하여 공유기를 최대한 같은 간격으로 배치하기
*/

public class Main {

	static int N, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int answer = 0;
		// 간격을 기준으로 공유기를 설치할 수 있는지 검사 => 실패하면 간격을 줄이고, 성공하면 간격을 늘려 최대를 찾는다.
		int left = 1; // 최소 간격
		int right = house[N-1]-house[0]; // 최대 간격
		while(left<=right) {
			int mid = (left+right)/2;
			// mid를 통해 정한 간격을 집집마다 돌며 검사를 한다.
			int cnt = 1; // 공유기 개수 세기
			int last = house[0] + mid;
			for (int i = 1; i < house.length; i++) {
				if(house[i]>=last) { // 최소 떨어져야 하는 거리보다 더 떨어져있다면 공유기 설치
					cnt++;
					last = house[i]+mid;
				}
			}
			if(cnt >= C) { // 공유기를 갖고있는 것보다 더 쓰거나 다썼다. => 간격을 늘린다.
				answer = mid; // 현재 값을 답에 저장
				left = mid + 1;
			}else { // 공유기를 다 설치 못해서 남는다. => 간격을 줄인다.
				right = mid - 1;
			}
		}
			
		System.out.println(answer);
	}

}