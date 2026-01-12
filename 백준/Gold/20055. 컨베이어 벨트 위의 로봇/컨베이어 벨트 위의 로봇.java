import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] arr;
	static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[2 * n + 1];
        check = new boolean[2 * n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;

        while (true) {
            step++;

            // 1/ 벨트 회전
            moveBelt();
            check[n] = false;

            // 2. 배치된 로봇들 한칸씩 이동
            moveRobot();
            check[n] = false;

            // 3. 로봇 넣을수있으면 넣기
            if (arr[1] > 0 && !check[1]) {
                check[1] = true;
                arr[1]--;
            }

            // 4. 내구도 0 검사
            if (countZero() >= k) {
                System.out.println(step);
                break;
            }
        }
    }

	private static void moveBelt() {
        int tmp = arr[2 * n];
        for (int i = 2 * n; i >= 2; i--) {
            arr[i] = arr[i - 1];
            check[i] = check[i - 1];
        }
        arr[1] = tmp;
        check[1] = false;
    }

	private static void moveRobot() {
        for (int i = n - 1; i >= 1; i--) {
			// 현재 칸에 로봇이 있고, 다음칸에 로봇이 없음 -> 한칸이동
            if (check[i] == true && check[i + 1] == false && arr[i + 1] > 0) {
				check[i + 1] = true;
				check[i] = false;
                arr[i + 1]--;
            }
        }
    }

    private static int countZero() {
        int cnt = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (arr[i] == 0) cnt++;
        }
        return cnt;
    }
}
