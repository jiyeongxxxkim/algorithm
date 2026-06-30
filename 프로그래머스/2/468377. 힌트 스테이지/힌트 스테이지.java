class Solution {
   int minTotalCost = Integer.MAX_VALUE;
    int n;

    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        int[] hints = new int[n]; // 각 스테이지별로 보유한 힌트권 개수를 저장할 배열
        
        // 0번 스테이지(실제 1번), 현재 누적 비용 0, 힌트 배열 들고 DFS 시작
        dfs(0, 0, hints, cost, hint);
        
        return minTotalCost;
    }

    private void dfs(int stage, int currentCost, int[] hints, int[][] cost, int[][] hint) {
        // 1. 가지치기 (Pruning): 이미 구한 최소 비용보다 현재 비용이 크거나 같으면 더 볼 필요 없음
        if (currentCost >= minTotalCost) {
            return;
        }

        // 2. 현재 스테이지 클리어 비용 계산
        // 힌트권은 최대 (n-1)개까지만 적용 가능
        int usableHints = Math.min(hints[stage], n - 1); 
        int clearCost = cost[stage][usableHints];
        int nextCost = currentCost + clearCost;

        // 클리어 비용을 더한 후에도 가지치기 한 번 더 수행
        if (nextCost >= minTotalCost) {
            return;
        }
        // 3. 종료 조건: 마지막 스테이지(n-1)에 도달한 경우
        if (stage == n - 1) {
            minTotalCost = Math.min(minTotalCost, nextCost);
            return;
        }

        // 4. 다음 스테이지로 넘어가는 2가지 분기 (번들을 산다 vs 안 산다)
        
        // [선택 A] 힌트 번들을 구매하지 않고 넘어가는 경우
        dfs(stage + 1, nextCost, hints, cost, hint);

        // [선택 B] 힌트 번들을 구매하는 경우
        int bundlePrice = hint[stage][0];
        
        // 번들에 포함된 힌트권들을 배열에 추가
        for (int i = 1; i < hint[stage].length; i++) {
            int targetStage = hint[stage][i] - 1; // 1-based index를 0-based로 변환
            hints[targetStage]++;
        }

        // 구매 비용을 더해서 다음 스테이지로 탐색
        dfs(stage + 1, nextCost + bundlePrice, hints, cost, hint);

        // 백트래킹(Backtracking): 다른 분기 탐색을 위해 추가했던 힌트권들을 다시 원상복구
        for (int i = 1; i < hint[stage].length; i++) {
            int targetStage = hint[stage][i] - 1;
            hints[targetStage]--;
        }
    }
}