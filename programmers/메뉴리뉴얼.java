import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since 2021. 3. 28.
 * @author Jin
 * @see https://programmers.co.kr/learn/courses/30/lessons/72411
 * @acc 100/100
 * @eff
 * @caution 2021 KAKAO BLIND RECRUITMENT : 메뉴 리뉴얼
 */

public class 메뉴리뉴얼 {

	static Map<String, Integer> pair = new HashMap<>();
	static int max = 0;

	static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		List<String> list = new ArrayList<>();

		for (int cou : course) {
			max = 0;
			pair = new HashMap<>();
			for (int i = 0; i < orders.length; i++) {
				char[] c = orders[i].toCharArray();
				Arrays.sort(c);
				comb(cou, new char[cou], 0, c);
			}
			for (Map.Entry<String, Integer> e : pair.entrySet()) {
				//System.out.println(e.getKey() + ", " + e.getValue());
				if (e.getValue() >= 2 && e.getValue() == max)
					list.add(e.getKey());
			}
		}

		Collections.sort(list);
		answer = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = String.valueOf(list.get(i));
		}
		//System.out.println(Arrays.toString(answer));
		return answer;
	}

	static void comb(int toChoose, char[] choosed, int startIdx, char[] s) {
		if (toChoose > s.length)
			return;
		if (toChoose == 0) {
			String temp = String.valueOf(choosed);
			//System.out.println(temp);
			if (pair.containsKey(temp))
				pair.replace(temp, pair.get(temp) + 1);
			else
				pair.put(temp, 1);
			max = Math.max(max, pair.get(temp));
			return;
		}

		for (int i = startIdx; i < s.length; i++) {
			choosed[choosed.length - toChoose] = s[i];
			comb(toChoose - 1, choosed, i + 1, s);
		}
	}

	public static void main(String[] args) {
		solution(new String[] { "XYZ", "XWY", "WXA"}, new int[] { 2, 3, 4 });
	}
}
