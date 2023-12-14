import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int dot = 2;

        for (int i = 1; i <= t; i++) {
            dot += (dot - 1);
        }
        System.out.print(dot * dot);
    }
    
}
