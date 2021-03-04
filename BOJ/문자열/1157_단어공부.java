import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1157
* @mem 21824kb
* @time 292ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		s = s.toUpperCase();
		int[] count = new int[26];
		for(int i=0; i<s.length(); i++) {
			count[(int)s.charAt(i)-65]++;
		}
		int max = 0;
		char c = 0;
		for(int i=0; i<count.length; i++) {
			if(count[i]>max) {
				max = count[i];
				c = (char)(65+i);
				}
			else if(max!=0 && count[i] == max) {
				c='?';
			}
		}
		System.out.println(c);
	}

	
}