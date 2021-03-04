import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/5430
* @mem 89684kb
* @time 2864ms
* @caution
*/

public class AC_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			// 정보 받기
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			s = s.substring(1, s.length()-1); // 앞 뒤 대괄호 빼기
			List<Integer> arr = new ArrayList<>(); // 숫자를 담을 리스트
			st = new StringTokenizer(s,","); // 명령문을 , 기준으로 파싱
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			p = p.replace("RR", ""); // 연속 두번 뒤집는거 삭제
			int reverse = -1; // 뒤집기 여부 (1: 뒤집은 상태, -1: 안 뒤집은 상태)
			boolean error = false; // 에러 여부
			for (int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'D') { // 맨 앞 버리기
					if(arr.size()==0) {
						output.append("error\n");
						error = true;
						break;
					}
					else {
						if(reverse == -1) arr.remove(0);
						else arr.remove(arr.size()-1);
					}
				}else { // 뒤집기
					reverse *= -1; 
				}
			}
			
			if(!error) {
				output.append("[");
				if(reverse == -1) {
					for (int i = 0; i < arr.size(); i++) {
						if(i+1==arr.size()) output.append(arr.get(i));
						else output.append(arr.get(i)).append(",");
					}
				}else {
					for (int i = arr.size()-1; i >= 0; i--) {
						if(i==0) output.append(arr.get(i));
						else output.append(arr.get(i)).append(",");
					}
				}
				output.append("]\n");
			}
		}
		System.out.println(output);
	}
}
