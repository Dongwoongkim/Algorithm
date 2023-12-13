import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        for (int i = 0; i < Integer.valueOf(s); i++) {
            String s1 = br.readLine();
            List<String> numbers = Arrays.stream(s1.split(" ")).collect(Collectors.toList());
            bw.write(Integer.valueOf(numbers.get(0)) + Integer.valueOf(numbers.get(1)) + "\n");
        }
        bw.flush();
    }
}
