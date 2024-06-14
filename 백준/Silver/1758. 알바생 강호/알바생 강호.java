import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int tip = arr.get(i) - (i);
            if (tip > 0) {
                ans += tip;
            }
        }
        System.out.println(ans);
    }
}
