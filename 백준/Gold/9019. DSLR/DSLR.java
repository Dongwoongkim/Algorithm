import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(getAnswer(start, end)).append("\n");
		}

		System.out.println(sb);
	}

	private static String getAnswer(int start, int end) {
		boolean[] visited = new boolean[10000];
		String[] paths = new String[10000];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited[start] = true;
		paths[start] = "";

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == end) break;

			int d = commandD(cur);
			int s = commandS(cur);
			int l = commandL(cur);
			int r = commandR(cur);

			if (!visited[d]) {
				visited[d] = true;
				paths[d] = paths[cur] + "D";
				queue.add(d);
			}

			if (!visited[s]) {
				visited[s] = true;
				paths[s] = paths[cur] + "S";
				queue.add(s);
			}

			if (!visited[l]) {
				visited[l] = true;
				paths[l] = paths[cur] + "L";
				queue.add(l);
			}

			if (!visited[r]) {
				visited[r] = true;
				paths[r] = paths[cur] + "R";
				queue.add(r);
			}
		}

		return paths[end];
	}
	private static int commandD(int n) {
		return (n * 2) % 10000;
	}

	private static int commandS(int n) {
		return (n == 0) ? 9999 : n - 1;
	}

	private static int commandL(int n) {
		return (n % 1000) * 10 + n / 1000;
	}

	private static int commandR(int n) {
		return (n % 10) * 1000 + n / 10;
	}
}
