import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] state = new int[5][10];
	static int k;
	static boolean[] check = new boolean[5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 4; i++) {
			String line = br.readLine();
			for (int j = 1; j <= 8; j++) {
				state[i][j] = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
			}
		}

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			check = new boolean[5];
			move(l, c);
		}

		System.out.println(state[1][1] +
			2 * state[2][1] +
			4 * state[3][1] +
			8 * state[4][1]);
	}

	private static void move(int l, int c) {
		if (l == 0 || l == 5) {
			return;
		}

		check[l] = true;

		// 좌 바퀴 회전
		if ((l - 1 >= 1) && state[l][7] != state[l - 1][3]) {
			if (!check[l - 1]) {
				check[l - 1] = true;
				if (c == 1) {
					move(l - 1, -1);
				} else {
					move(l - 1, 1);
				}
			}
		}

		// 우 바퀴 회전
		if ((l + 1) <= 4 && state[l][3] != state[l + 1][7]) {
			if (!check[l + 1]) {
				check[l + 1] = true;
				if (c == 1) {
					move(l + 1, -1);
				} else {
					move(l + 1, 1);
				}
			}
		}

		if (c == 1) {
			// 시계 방향
			for (int i = 9; i >= 2; i--) {
				state[l][i] = state[l][i - 1];
			}
			state[l][1] = state[l][9];
		}

		if (c == -1) {
			// 반시계 방향
			state[l][9] = state[l][1];

			for (int i = 1; i <= 8; i++) {
				state[l][i] = state[l][i + 1];
			}
		}

		// for (int j = 1; j <= 8; j++) {
		// 	System.out.print(state[1][j]);
		// }
		// System.out.println();
	}
}
