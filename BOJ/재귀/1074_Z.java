package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 16.
* @author Jin
* @see https://www.acmicpc.net/problem/1074
* @mem 14608kb
* @time 132ms
* @caution
*/

public class Z_1074 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);

		int answer = findNum(size, 0, 0, 0, R, C);
		
		System.out.println(answer);
	}
	
	static int findNum(int size, int startI, int startJ, int num, int findI, int findJ) {
		if(size == 2) {
			if(startI == findI && startJ == findJ) {
				return num;
			}else if(startI == findI && startJ+1 == findJ) {
				return num+1;
			}else if(startI+1 == findI && startJ == findJ) {
				return num+2;
			}else if(startI+1 == findI && startJ+1 == findJ) {
				return num+3;
			}
			
		}
		int divNum = size/2;
		int result = -1;
		if(startI <= findI && findI < startI+divNum && 
				startJ <= findJ && findJ < startJ+divNum) {
			result = findNum(divNum, startI, startJ, num, findI, findJ);
			
		}else if(startI <= findI && findI < startI+divNum && 
				startJ+divNum <= findJ && findJ < startJ+2*divNum) {
			result = findNum(divNum, startI, startJ+divNum, num+(divNum*divNum), findI, findJ);
			
		}else if(startI+divNum <= findI && findI < startI+2*divNum && 
				startJ <= findJ && findJ < startJ+divNum) {
			result = findNum(divNum, startI+divNum, startJ, num+(2*(divNum*divNum)), findI, findJ);
			
		}else if(startI+divNum <= findI && findI < startI+2*divNum && 
				startJ+divNum <= findJ && findJ < startJ+2*divNum) {
			result = findNum(divNum, startI+divNum, startJ+divNum, num+(3*(divNum*divNum)), findI, findJ);
		}
			
		return result;
	}
}
