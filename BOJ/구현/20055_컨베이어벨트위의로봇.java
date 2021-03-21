import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/20055
* @mem 297324kb
* @time 1540ms
* @caution S1
*/

public class 20055_컨베이어벨트위의로봇 {

	static int N, K;
	static Deque<Integer> belt;
	static List<Integer> beltPower;
	static Queue<Integer> robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new ArrayDeque<>();
		beltPower = new ArrayList<>(); // 내구도
		robot = new LinkedList<>(); // 벨트에 올라간 로봇 순서대로 로봇 위치 저장

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * N; i++) {
			belt.offerLast(i);
			beltPower.add(Integer.parseInt(st.nextToken()));
		}

		int cnt = 0;
		int answer = 0;
		while (cnt < K) {
			answer++;

			// 1. 벨트 한 칸 회전
			int temp = belt.pollLast();
			belt.offerFirst(temp);

			// 내려가는 위치 로봇 내려주기
			temp = belt.peekFirst();
			temp += (N - 1);
			if (temp >= (2 * N))
				temp %= (2 * N);
			if (robot.contains(temp))
				robot.remove(temp);

			// 2. 벨트에 올라간 로봇들 이동
			int qsize = robot.size();
			for (int s = 0; s < qsize; s++) {
				int robIdx = robot.poll(); // 로봇이 서있는 칸 번호
				int checkIdx = robIdx + 1;
				if (checkIdx == 2 * N)
					checkIdx = 0;

				// 이동하려는 칸에 로봇 유무 확인
				if (!robot.contains(checkIdx)) { // 로봇 없어서 이동 가능
					boolean canmove;
					canmove = checkPower(checkIdx);

					if (canmove) {// 내구도 확인 후 움직일 수 있다면
						beltPower.set(checkIdx, beltPower.get(checkIdx) - 1); // 내구도 -1
						if (beltPower.get(checkIdx) == 0)
							cnt++;
						robot.offer(checkIdx);
					} else { // 이동 불가
						robot.offer(robIdx);
					}
				} else {// 이동 불가
					robot.offer(robIdx);
				}
			}

			// 내려가는 위치 로봇 내려주기
			temp = belt.peekFirst();
			temp += (N - 1);
			if (temp >= (2 * N))
				temp %= (2 * N);
			if (robot.contains(temp))
				robot.remove(temp);

			// 3. 올라가는 위치에 로봇 없으면 로봇 올리기
			temp = belt.peekFirst();
			if (!robot.contains(temp) && beltPower.get(temp) >= 1) {
				robot.offer(temp);
				beltPower.set(temp, beltPower.get(temp) - 1);
				if (beltPower.get(temp) == 0)
					cnt++;
			}

		}

		System.out.println(answer);
	}

	static boolean checkPower(int idx) {
		if (beltPower.get(idx) >= 1)
			return true;
		return false;
	}
}
