import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int[][] map;
	static boolean[][] check;
	static int ans = 0;
	static PriorityQueue<Position> mq = new PriorityQueue<>();

	/*
	1) 초기 상어 크기는 2
	2) 자기보다 작은 물고기만 먹을 수 있음
	3) 현재 상어 크기가 n이라면 자기보다 작은 물고기 n마리를 먹어야 현재 크기가 1증가
	4) 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 감
	5) 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다. (1: 위,2 : 좌)

	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];

		int curX = -1;
		int curY = -1;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					curX = i;
					curY = j;
					map[curX][curY] = 0;
				}

			}
		}

		/*
		- 먹을 물고기가 없을 때 까지 (bfs 수행 후 flag = false)
		- 1) 현재 시점에서 먹을 수 있는 크기의 물고기를 먹고 (bfs)
		- 2) 크기 갱신
		 */

		/*
		pseudo
		 */
		int curSize = 2;
		int eatCnt = 0;

		while (true) {
			check = new boolean[n + 1][n + 1];
			int result = bfs(curX, curY, curSize);

			if (result > 0) {
				curX = mq.peek().x;
				curY = mq.peek().y;
				eatCnt++;
				ans += result;

				if (eatCnt == curSize) {
					curSize++;
					eatCnt = 0;
				}
			} else {
				break;
			}
		}

		System.out.println(ans);
	}

	private static int bfs(int x, int y, int size) {
		Queue<Position> queue = new LinkedList<>();
		mq = new PriorityQueue<>();
		queue.add(new Position(x, y, 0));
		check[x][y] = true;

		while (!queue.isEmpty()) {
			Position pos = queue.poll();

			int curX = pos.x;
			int curY = pos.y;
			int curMoveCnt = pos.moveCnt;

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && !check[nx][ny]) {

					if (map[nx][ny] < size) {
						check[nx][ny] = true;
						queue.add(new Position(nx, ny, curMoveCnt + 1)); // 이동

						// 물고기인 경우
						if (map[nx][ny] != 0) {
							mq.add(new Position(nx, ny, curMoveCnt + 1)); // 먹이 도착
						}
					}

					if (map[nx][ny] == size) {
						check[nx][ny] = true;
						queue.add(new Position(nx, ny, curMoveCnt + 1)); // 이동
					}
				}
			}
		}

		// 초기 좌표에서 갈 수 있는 곳 다 갔다면, 거리가 가장 짧은 곳에 상어 배치
		if (mq.isEmpty()) {
			return 0;
		}

		map[mq.peek().x][mq.peek().y] = 0;

		return mq.peek().moveCnt;
	}

	static class Position implements Comparable {
		int x;
		int y;
		int moveCnt;

		public Position(int x, int y, int moveCnt) {
			this.x = x;
			this.y = y;
			this.moveCnt = moveCnt;
		}

		@Override
		public int compareTo(Object o) {
			Position p = (Position)o;
			if (this.moveCnt != p.moveCnt) {
				return this.moveCnt - p.moveCnt;   // moveCnt 오름차순
			}

			if (this.x != p.x) {
				return this.x - p.x;               // x 오름차순
			}

			return this.y - p.y;                   // y 오름차순
		}
	}
}
