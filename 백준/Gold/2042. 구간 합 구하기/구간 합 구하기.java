import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < m + k; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // b번째 수를 c로 바꾸기
            if (a == 1) {
                tree.update(1, 1, n, b, c - arr[b]);
            }

            // b번째 수부터 c번째 수 까지의 구간합 구하고 출력
            if (a == 2) {
                sb.append(tree.find(1, 1, n, b, (int) c)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        long[] tree;

        public SegmentTree(int size) {
            tree = new long[size * 4];
            initTree(1, 1, size);
        }

        private long initTree(int root, int start, int end) {
            // 가장 끝에 도달한 경우
            if (start == end) {
                tree[root] = arr[start];
                return tree[root];
            }

            int mid = (start + end) / 2;

            tree[root] = initTree(root * 2, start, mid) + initTree(root * 2 + 1, mid + 1, end);

            return tree[root];
        }

        private long find(int root, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            // 범위 안에 있는 경우
            if (left <= start && right >= end) {
                return tree[root];
            }

            int mid = (start + end) / 2;

            // 자식 노드로부터 재귀적으로 탐색
            return find(root * 2, start, mid, left, right) + find(root * 2 + 1, mid + 1, end, left, right);
        }

        private void update(int root, int start, int end, int changeIdx, long diff) {
            // 범위 밖에 있으면 변경 X
            if (changeIdx < start || changeIdx > end) {
                return;
            }

            // 범위 안에 있으면 내려가면서 갱신
            tree[root] += diff;

            if (start == end) {
                arr[start] += diff;
                return;
            }

            int mid = (start + end) / 2;

            // 왼쪽 자식 갱신
            update(root * 2, start, mid, changeIdx, diff);

            // 오른쪽 자식 갱신
            update(root * 2 + 1, mid + 1, end, changeIdx, diff);
        }
    }
}
