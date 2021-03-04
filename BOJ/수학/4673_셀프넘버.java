/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/4673
* @mem 19032kb
* @time 260ms
* @caution
*/

public class Main {
	public static void main(String[] args) {
		int[] arr = new int[10001];
		
		for(int i=0; i<10001; i++) {
			String s = Integer.toString(i);
			int num = i;
			for(int j=0; j<s.length(); j++) {
				num+=Integer.parseInt(s.charAt(j)+"");
			}
			if(num<10001) arr[num]++;
		}
		
		for(int i=1; i<10001; i++) {
			if(arr[i]==0) System.out.println(i);
		}
	}

}