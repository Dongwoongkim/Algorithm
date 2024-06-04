import java.util.*;

class Solution {
    
    static int answer = -1;

    public static int solution(int[] info, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] check = new boolean[info.length + 1];

        dfs(0, graph, 0, 0, new ArrayList<>(), info, check);
        return answer;
    }

    private static void dfs(int next, List<List<Integer>> graph, int wolf, int sheep, List<Integer> visitPossible,
                            int[] info, boolean[] check) {
        if (info[next] == 0) {
            sheep++;
        }
        if (info[next] == 1) {
            wolf++;
        }
        if (wolf >= sheep) {
            return;
        }
        
        // 양의 최대 수 저장
        answer = Math.max(answer, sheep);

        // 현재 노드에서 이동 가능한 노드 => 현재까지 거쳐온 노드들의 자식노드 + 현재 노드의 자식 노드 - 현재노드
        List<Integer> currentVisitable = new ArrayList<>(visitPossible);

        // 현재 노드의 자식 노드
        if (!graph.get(next).isEmpty()) {
            currentVisitable.addAll(graph.get(next));
        }

        // 현재 노드 삭제
        currentVisitable.remove(Integer.valueOf(next));

        for (int i = 0; i < currentVisitable.size(); i++) {
            dfs(currentVisitable.get(i), graph, wolf, sheep, currentVisitable, info, check);
        }
    }
}