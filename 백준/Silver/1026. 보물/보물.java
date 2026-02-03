import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> arr = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        Collections.sort(arr2);
        Collections.reverse(arr);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr.get(i) * arr2.get(i);
        }

        System.out.println(ans);
    }
}
