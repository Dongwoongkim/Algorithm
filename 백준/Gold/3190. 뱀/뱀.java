import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k, l;
	static char[][] board;
	static Queue<Info> info = new LinkedList<>();
	static Deque<SnakeInfo> snakeInfo = new ArrayDeque<>();
	static char dir;
	static boolean over = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		board = new char[n + 1][n + 1];

		board[1][1] = 's';

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 'a';
		}

		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			info.add(new Info(s, c));
		}

		int second = 0;
		snakeInfo.add(new SnakeInfo(1, 1));
		dir = 'R';

		while (true) {
			second++;

			move(dir);
			if (over) {
				break;
			}

			// 방향 전환 (
			if (!info.isEmpty() && info.peek().second == second) {
				char turn = info.poll().turn;

				if (turn == 'L') {
					if (dir == 'R') {
						dir = 'U';
						continue;
					} else if (dir == 'L') {
						dir = 'D';
					} else if (dir == 'U') {
						dir = 'L';
					} else if (dir == 'D') {
						dir = 'R';
					}
				}

				// 오른쪽
				if (turn == 'D') {
					if (dir == 'R') {
						dir = 'D';
					} else if (dir == 'L') {
						dir = 'U';
					} else if (dir == 'U') {
						dir = 'R';
					} else if (dir == 'D') {
						dir = 'L';
					}
				}
			}
		}

		System.out.println(second);
	}

	static class Info {
		int second;
		char turn;

		public Info(int second, char turn) {
			this.second = second;
			this.turn = turn;
		}
	}

	static class SnakeInfo {
		int x;
		int y;

		public SnakeInfo(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void move(char dir) {
		SnakeInfo head = snakeInfo.peekFirst();
		int x = head.x;
		int y = head.y;

		int nx = -1;
		int ny = -1;

		if (dir == 'L') {
			nx = x;
			ny = y - 1;
		}
		if (dir == 'R') {
			nx = x;
			ny = y + 1;
		}
		if (dir == 'U') {
			nx = x - 1;
			ny = y;
		}
		if (dir == 'D') {
			nx = x + 1;
			ny = y;
		}

		// 벽이랑 부딪힌 경우
		if (nx == 0 || ny == 0 || nx == n + 1 || ny == n +1) {
			over = true;
			return;
		}

		// 몸이랑 부딪힘
		if (board[nx][ny] == 's') {
			over = true;
			return;
		}

		// 머리전진
		snakeInfo.addFirst(new SnakeInfo(nx, ny));

		// 사과인경우 머리로바꿈
		if (board[nx][ny] == 'a') {
			board[nx][ny] = 's';
		} else {
			SnakeInfo tail = snakeInfo.pollLast(); // 사과아니면 꼬리자름
			board[tail.x][tail.y] = '_';
			board[nx][ny] = 's';
		}
	}
}
