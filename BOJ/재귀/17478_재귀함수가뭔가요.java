package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 1.
* @author
* @see https://www.acmicpc.net/problem/17478
* @mem 14720kb
* @time 152ms
* @caution
*/
public class 재귀함수가_뭔가요_17478 {

	static StringBuilder output = new StringBuilder();
	static String[] s = {"\"재귀함수가 뭔가요?\"\n" ,
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" ,
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" , 
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
			"라고 답변하였지.\n"};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		output.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		int T = Integer.parseInt(br.readLine());
		re(0,T);
		System.out.println(output);
		
	}
	
	public static void re(int i, int last) {
		if(i==last) {
			for(int k=0; k<i; k++) {
				output.append("____");
			}
			output.append("\"재귀함수가 뭔가요?\"\n");
			for(int k=0; k<i; k++) {
				output.append("____");
			}
			output.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for(int k=0; k<i; k++) {
				output.append("____");
			}
			output.append("라고 답변하였지.\n");
			return;
		}
		for(int j=0; j<s.length; j++) {
			for(int k=0; k<i; k++) {
				output.append("____");
			}
			output.append(s[j]);
			if(j==3) re(i+1, last);
		}
		
	}
}
