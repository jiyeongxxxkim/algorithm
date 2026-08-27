import java.util.*;

class Solution {
    int maxInfected = 0;
    List<int[]>[] graph;

    public int solution(int n, int infection, int[][] edges, int k) {
        // 인접 리스트 생성 (연결 노드, 파이프 타입)
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int type = edge[2];
            graph[u].add(new int[]{v, type});
            graph[v].add(new int[]{u, type});
        }

        // 초기 감염 상태 설정
        boolean[] initialInfected = new boolean[n + 1];
        initialInfected[infection] = true;

        // DFS 백트래킹 시작: 파이프를 여는 순서 조합 탐색
        dfs(0, k, 0, initialInfected, n);

        return maxInfected;
    }

    // depth: 현재 행동 횟수, k: 최대 행동 수, prevType: 직전에 연 파이프 타입
    private void dfs(int depth, int k, int prevType, boolean[] infected, int n) {
        // 현재까지 감염된 배양체 수 계산 및 최댓값 갱신
        int currentCount = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) currentCount++;
        }
        maxInfected = Math.max(maxInfected, currentCount);

        // 모든 노드가 감염되었거나 최대 행동 수에 도달하면 종료
        if (currentCount == n || depth == k) {
            return;
        }

        // 1(A), 2(B), 3(C) 파이프 중 직전에 열었던 파이프를 제외하고 선택
        for (int type = 1; type <= 3; type++) {
            if (type == prevType) continue;

            // 현재 파이프를 열었을 때 새롭게 전파되는 상태 시뮬레이션 (BFS)
            boolean[] nextInfected = simulate(infected, type, n);
            dfs(depth + 1, k, type, nextInfected, n);
        }
    }

    // 선택된 파이프 타입만 열려 있을 때 감염 확산 (BFS)
    private boolean[] simulate(boolean[] infected, int pipeType, int n) {
        boolean[] nextInfected = infected.clone();
        Queue<Integer> q = new LinkedList<>();

        // 현재 이미 감염되어 있는 모든 노드를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (nextInfected[i]) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : graph[cur]) {
                int nextNode = next[0];
                int edgeType = next[1];

                // 아직 감염되지 않았고, 현재 열려있는 파이프 타입과 일치하면 전파
                if (!nextInfected[nextNode] && edgeType == pipeType) {
                    nextInfected[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }

        return nextInfected;
    }
}