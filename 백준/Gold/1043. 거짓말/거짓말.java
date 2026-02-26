import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[] knows;
    static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        knows = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < knowCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            knows[num] = true;
        }

        for (int i = 0; i < m; i++) {
            parties.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                parties.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < parties.size(); i++) {
                List<Integer> party = parties.get(i);
                boolean flag = false;

                for (int j = 0; j < party.size(); j++) {
                    Integer num = party.get(j);
                    if (knows[num]) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < party.size(); j++) {
                        Integer num = party.get(j);
                        knows[num] = true;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < parties.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < parties.get(i).size(); j++) {
                Integer num = parties.get(i).get(j);
                if (knows[num]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}