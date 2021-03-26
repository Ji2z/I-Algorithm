import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 26.
 * @author Jin
 * @see https://www.acmicpc.net/problem/10814
 * @mem 47760kb
 * @time 552ms
 * @caution S5
 */

public class 10814_나이순정렬 {
	
	static class Person implements Comparable<Person>{
		int id;
		int age;
		String name;
		
		public Person(int id, int age, String name) {
			super();
			this.id = id;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			int diff = Integer.compare(this.age, o.age);
			return diff==0?Integer.compare(this.id, o.id):diff;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Person> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			pq.offer(new Person(i,age,name));
		}
		
		while(!pq.isEmpty()) {
			Person p = pq.poll();
			output.append(p.age).append(" ").append(p.name).append("\n");
		}
		
		System.out.println(output);
	}

}
