import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2588
* @mem 18316kb
* @time 232ms
* @caution
*/

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a*(b%10));
		System.out.println(a*((b%100)/10));
		System.out.println(a*((b%1000)/100));
        System.out.println(a*b);
	}
}