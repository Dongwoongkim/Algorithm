import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        List<Integer> kmp = kmp(t, p);

        System.out.println(kmp.size());
        for (Integer i : kmp) {
            System.out.println(i);
        }
    }

    public static int[] makePI(String pattern) {
        int size = pattern.length();
        int[] pi = new int[size];

        int j = 0;
        for (int i = 1; i < size; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
        return pi;
    }

    public static List<Integer> kmp(String t, String p) {
        int[] pi = makePI(p);

        List<Integer> ans = new ArrayList<>();
        int parentSize = t.length();
        int patternSize = p.length();

        int j = 0;
        for (int i = 0; i < parentSize; i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == patternSize - 1) {
                    ans.add(i - patternSize + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
