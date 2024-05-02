import java.util.Scanner;

public class Main {

    static int[] parent;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();

        parent = new int[g + 1];

        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int plane = sc.nextInt();

            int emptyGate = find(plane);

            if (emptyGate == 0) {
                // 비행기가 어느 게이트에도 도킹할 수 없다면 공항이 폐쇄되고, 이후 어떤 비행기도 도착할 수 없다.
                break;
            }

            if (emptyGate != 0) {
                cnt++;
                // 다음에 해당 게이트로 들어와야 하는 비행기가 들어오면 차선책으로 -1번을 부여
                union(emptyGate - 1, emptyGate);
            }
        }
        System.out.println(cnt);
    }

    private static int find(int plane) {
        if (parent[plane] == plane) {
            return plane;
        }

        parent[plane] = find(parent[plane]); // 루트 노드

        return parent[plane];
    }

    private static void union(int x, int y) {
        x = find(x); // 루트 노드 찾기
        y = find(y); // 루트 노드 찾기

        if (x == y) { // 루트 노드가 같다면, 즉 연결되어 있다면
            return;
        }

        parent[y] = x;
    }
}
