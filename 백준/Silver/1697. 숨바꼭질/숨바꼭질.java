import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] step = new int[100_001 * 2];
	static boolean[] check = new boolean[100_001 * 2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 200_000; i++) {
			step[i] = Integer.MAX_VALUE;
		}

		step[n] = 0;

		System.out.println(bfs(new Position(n, 0)));
	}

	private static int bfs(Position position) {
		int answer = -1;
		Queue<Position> queue = new LinkedList<>();
		queue.add(position);
		check[position.pos] = true;

		while (!queue.isEmpty()) {
			Position pos = queue.poll();

			int currentPos = pos.pos;
			int currentStep = pos.step;

			if(currentPos == m) {
				answer = currentStep;
				break;
			}

			int nextPos1 = currentPos - 1;
			int nextPos2 = currentPos + 1;
			int nextPos3 = currentPos * 2;

			if (isValid(nextPos1) && !check[nextPos1]) {
				queue.add(new Position(nextPos1, currentStep + 1));
				check[nextPos1] = true;
				step[nextPos1] = Math.max(step[nextPos1], currentStep + 1);
			}

			if (isValid(nextPos2) && !check[nextPos2]) {
				queue.add(new Position(nextPos2, currentStep + 1));
				check[nextPos2] = true;
				step[nextPos2] = Math.max(step[nextPos2], currentStep + 1);
			}

			if (isValid(nextPos3) && !check[nextPos3]) {
				queue.add(new Position(nextPos3, currentStep + 1));
				check[nextPos3] = true;
				step[nextPos3] = Math.max(step[nextPos3], currentStep + 1);
			}
		}
		return answer;
	}

	private static boolean isValid(int pos) {
		return pos >= 0  && pos <= 100_000;
	}

	static class Position {
		int pos;
		int step;

		public Position(int pos, int step) {
			this.pos = pos;
			this.step = step;
		}
	}
}
