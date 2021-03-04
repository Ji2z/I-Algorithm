import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @since 2021. 3. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/2661
* @mem 11404kb
* @time 76ms
* @caution
*/

public class 좋은수열_2661 {
	
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(1);
			change(i, false);
		}
		
		for (int i = 0; i < N; i++) {
			output.append(list.get(i));
		}
		System.out.println(output);
	}
	
	static boolean check(int len, int size) {
		boolean pattern = false;
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if(list.get(size-i)==list.get(size-len-i)) {
				cnt++;
			}else break;
		}
		if(cnt == len) pattern = true;
		return pattern;
	}
	
	static void change(int idx, boolean rechange) {
		if(rechange) {
			if(list.get(idx) == 1 && list.get(idx-1) == 2) {
				list.set(idx, 3);
			}else if(list.get(idx) == 1 && list.get(idx-1) == 3) {
				list.set(idx, 2);
			}else if(list.get(idx) == 2 && list.get(idx-1) == 1) {
				list.set(idx, 3);
			}else {
				change(idx-1, true);
				list.set(idx, 1);
			}
		}
		for (int j = 1; j <= (idx+1)/2; j++) {
			boolean check = check(j,idx);
			if(check) {
				if(list.get(idx) == 1) {
					list.set(idx, 2);
					j = 0;
				}
				else if(list.get(idx) == 2) {
					list.set(idx, 3);
					j = 0;
				}else {
					change(idx-1, true);
					list.set(idx, 1);
					j = 0;
				}
			}
		}
	}
}
