/**
* @since 2021. 3. 28.
* @author Jin
* @see https://programmers.co.kr/learn/courses/30/lessons/72410
* @acc 100/100
* @eff 
* @caution 2021 KAKAO BLIND RECRUITMENT : 신규 아이디 추천
*/
public class Solution {
	static public String solution(String new_id) {
        String answer = "";
        
        // 1. 모든 대문자를 소문자로
        answer = new_id.toLowerCase();
        
        // 2. 소문자, 숫자, -, _, . 제외한 모든 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3. .(마침표)가 2번 이상 연속이면 하나로 치환
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4. 마침표가 처음이나 끝이면 제거
        answer = answer.charAt(0)=='.'?answer.substring(1):answer;
        answer = answer.length()>0&&answer.charAt(answer.length()-1)=='.'?answer.substring(0, answer.length()-1):answer;
        
        // 5. 빈 문자열이면 a를 대입
        answer = answer.length()==0?"a":answer;
        
        // 6. 길이가 16자 이상이면 15까지만
        answer = answer.length()>=16?answer.substring(0,15):answer;
        
        // 4-1. 마침표가 처음이나 끝이면 제거
        answer = answer.charAt(0)=='.'?answer.substring(1):answer;
        answer = answer.length()>0&&answer.charAt(answer.length()-1)=='.'?answer.substring(0, answer.length()-1):answer;
        
        // 7. 길이가 2자 이하면 마지막 문자를 길이가 3이 될 때까지 반복
        answer = answer.length()<=2?answer.concat(new String(new char[3-answer.length()]).replace('\0', answer.charAt(answer.length()-1))):answer;
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}
	
}
