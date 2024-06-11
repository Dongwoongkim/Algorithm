import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] isExists = new int[1_000_001];
        int[] answer = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            isExists[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            int j = 2;
            int current = arr[i];
            while (true) {
                int next = j * current;
                if (next > 1_000_000) {
                    break;
                }
                if (isExists[next] != 0) {
                    // 현재 수는 패배
                    answer[current]++;
                    // 곱절 수는 패배
                    answer[next]--;
                }
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[arr[i]] + " ");
        }
        System.out.println(sb);

    }
}
