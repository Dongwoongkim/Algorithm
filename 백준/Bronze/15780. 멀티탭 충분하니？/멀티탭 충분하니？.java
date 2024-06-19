import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int man = Integer.parseInt(st.nextToken());
        int concent = Integer.parseInt(st.nextToken());
        int rst = 0;
        int arr[] = new int[concent + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < concent; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] % 2 == 0) {
                rst += arr[i] / 2;
            }
            if (arr[i] % 2 != 0) {
                rst += arr[i] / 2 + 1;
            }

        }

        if (man <= rst) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
