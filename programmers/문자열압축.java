import java.util.Arrays;

/**
* @since 2021. 5. 2.
* @author Jin
* @see https://programmers.co.kr/learn/courses/30/lessons/60057
* @acc 100/100
* @eff 
* @caution 2021 KAKAO BLIND RECRUITMENT : 문자열 압축
*/
public class 문자열압축 {
	static public int solution(String s) {
        int answer = 0;
        
        int[] result = new int[s.length()];
        
        for (int k = 1; k < s.length(); k++) {
        	String temp = s.substring(0,k);
        	int dup = 0;
			for (int i = k; i < s.length()-k+1; i+=k) {
				if(temp.equals(s.substring(i,i+k))){
					dup++;
				}else {
					result[k-1] = result[k-1] + k + (dup==0?0:(Integer.toString((dup+1)).length()));
					temp = s.substring(i,i+k);
					dup = 0;
					//System.out.println(i+", "+(i+k)+", "+s.length());
				}
			}
			result[k-1] = result[k-1] + k + (dup==0?0:(Integer.toString((dup+1)).length()));
			result[k-1] = result[k-1] + (s.length()%k);
		}
        
        result[s.length()-1] = s.length();
        
        //System.out.println(Arrays.toString(result));
        Arrays.sort(result);
       // System.out.println(Arrays.toString(result));
        answer = result[0];
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("xababcdcdababcdcd"));
	}
	
}
