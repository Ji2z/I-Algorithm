/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/15596
* @mem 422992kb
* @time 36ms
* @caution
*/

public class Test {
    long sum(int[] a) {
        long ans = 0;
        for(int i=0; i<a.length; i++) {
			ans+=a[i];
		}
        return ans;
    }
}