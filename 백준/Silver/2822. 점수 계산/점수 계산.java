import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        List<Pair> num = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            num.add(new Pair(Integer.parseInt(br.readLine()), i + 1));
        }

        Collections.sort(num, (a, b) -> b.first - a.first);

        for (int i = 0; i < 5; i++) {
            sum += num.get(i).first;
            index.add(num.get(i).second);
        }

        Collections.sort(index);

        System.out.println(sum);
        for (int i = 0; i < 5; i++) {
            System.out.print(index.get(i) + " ");
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
