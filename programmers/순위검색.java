/**
* @since 2021. 3. 28.
* @author Jin
* @see https://programmers.co.kr/learn/courses/30/lessons/72412
* @acc 40/40
* @eff 0/60
* @caution 2021 KAKAO BLIND RECRUITMENT : 순위 검색
*/

public class 순위검색 {
	static int[] solution(String[] info, String[] query) {
		int[] answer = {};
		answer = new int[query.length];
		
		String[][] table = new String[info.length][5];
		int idx = 0;
		for (String s : info) {
			table[idx++] = s.split(" ");
			//System.out.println(Arrays.toString(table[idx-1]));
		}
		
		idx = 0;
		for(String q : query) {
			String[] qrr = q.split("( and )| ");
			//System.out.println(Arrays.toString(qrr));
			for (int i = 0; i < table.length; i++) {
				boolean c1, c2, c3, c4, c5;
				c1 = qrr[0].equals("-")?true:table[i][0].equals(qrr[0]);
				if(!c1) continue;
				
				c2 = qrr[1].equals("-")?true:table[i][1].equals(qrr[1]);
				if(!c2) continue;
				
				c3 = qrr[2].equals("-")?true:table[i][2].equals(qrr[2]);
				if(!c3) continue;
				
				c4 = qrr[3].equals("-")?true:table[i][3].equals(qrr[3]);
				if(!c4) continue;
				
				c5 = qrr[4].equals("-")?true:Integer.parseInt(table[i][4])>=Integer.parseInt(qrr[4]);
				if(!c5) continue;
				
				answer[idx]++;
			}
			idx++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		solution(info, query);
	}
}
