import java.util.Scanner;

public class Main {

    static int[] parent;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();

        parent = new int[g + 1];

        for (int i = 0; i <= g; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int plane = sc.nextInt();

            int gonghang = find(plane);

            if (gonghang == 0) {
                break;
            }

            if (gonghang != 0) {
                cnt++;
                union(gonghang - 1, gonghang);
            }
        }

        System.out.println(cnt);
    }

    private static void union(int gonghang, int num) {
        gonghang = find(gonghang);
        num = find(num);

        if (num < gonghang) {
            parent[gonghang] = num;
            return;
        }

        parent[num] = gonghang;
    }

    private static int find(int num) {
        if (parent[num] == num) {
            return num;
        }

        parent[num] = find(parent[num]);

        return parent[num];
    }
}
