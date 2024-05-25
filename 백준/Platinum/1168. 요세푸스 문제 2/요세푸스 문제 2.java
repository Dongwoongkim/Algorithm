import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        SegmentTree tree = new SegmentTree(n);

        int idx = 0;

        sb.append("<");

        for (int i = 0; i < n; i++) {
            idx += (m);
            
            // 사이즈 만큼 모듈러
            if (idx % (n - i) == 0) {
                idx = n - i;
            } else {
                idx %= (n - i);
            }

            int num = tree.query(1, 1, n, idx);
            tree.update(1, 1, n, num);

            if (i != (n - 1)) {
                sb.append(num).append(", ");
            } else {
                sb.append(num);
            }

            idx -= 1;
        }
        sb.append(">");
        
        System.out.println(sb);
    }

    static class SegmentTree {

        int[] tree;

        public SegmentTree(int n) {

            // 트리 높이 - log2^n + 1
            int height = (int) (Math.ceil(Math.log(n) / Math.log(2))) + 1;

            // 노드 수
            int nodeCnt = (int) Math.pow(2, height);

            tree = new int[nodeCnt * 4];

            init(1, 1, n);
        }

        private int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = 1;
            }

            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
        }

        private int query(int node, int start, int end, int order) {
            if (start == end) {
                return start;
            }

            int mid = (start + end) / 2;

            if (order <= tree[2 * node]) {
                return query(2 * node, start, mid, order);
            }

            return query(2 * node + 1, mid + 1, end, order - tree[2 * node]);
        }

        private int update(int node, int start, int end, int deleteNum) {
            tree[node]--;

            if (start == end) {
                return 0;
            }

            int mid = (start + end) / 2;
            if (deleteNum <= mid) {
                return update(2 * node, start, mid, deleteNum);
            }

            return update(2 * node + 1, mid + 1, end, deleteNum);
        }
    }
}
