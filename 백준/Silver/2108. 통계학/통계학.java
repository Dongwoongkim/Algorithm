import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> arr = new ArrayList<>();
    static int[] frequency = new int[4001];
    static int[] mfrequency = new int[4001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
            sum += arr.get(i);
            if (arr.get(i) > 0) {
                frequency[arr.get(i)]++;
            } else {
                mfrequency[-arr.get(i)]++;
            }
        }

        int maxFrequency = 0;
        int frqN = 312312123;
        for (int i = 0; i < 4001; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                frqN = i;
            }

            if (mfrequency[i] > maxFrequency) {
                maxFrequency = mfrequency[i];
                frqN = -i;
            }
        }

        List<Integer> fqes = new ArrayList<>();
        for (int i = 0; i < 4001; i++) {
            if (frequency[i] == maxFrequency) {
                fqes.add(i);
            }

            if (mfrequency[i] == maxFrequency) {
                fqes.add(-i);
            }
        }

        Collections.sort(fqes);
        Collections.sort(arr);
        System.out.println(Math.round((double) sum / n));
        System.out.println(arr.get(arr.size() / 2));
        System.out.println(fqes.size() == 1 ? fqes.get(0) : fqes.get(1));
        System.out.println(arr.get(arr.size() - 1) - arr.get(0));
    }
}
