import java.util.*;

class Solution {
    int n, m, r, c, k;
    String answer = null; // 정답을 찾으면 여기에 저장
    
    // 사전순: d(아래), l(왼쪽), r(오른쪽), u(위)
    int[] dx = {1, 0, 0, -1}; 
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};
    
    public void dfs(int cx, int cy, int dis, StringBuilder sb) {
        // 이미 정답을 찾았다면 더 이상 탐색하지 않음 (가장 중요)
        if (answer != null) return;
        
        // 1. 가지치기: 현재 위치에서 목표까지의 최단 거리 계산
        int shortestPath = Math.abs(cx - r) + Math.abs(cy - c);
        int remain = k - dis;
        
        // 2. 가지치기: 남은 거리가 최단 거리보다 적거나, 홀수번 남아서 도달 불가능한 경우
        if (remain < shortestPath || (remain - shortestPath) % 2 != 0) {
            return;
        }
        
        // 목표 이동 횟수에 도달했을 때
        if (dis == k) {
            if (cx == r && cy == c) {
                answer = sb.toString(); // 첫 번째로 도달한 것이 무조건 사전순 1등
            }
            return;
        }
        
        // 사전순(d, l, r, u)으로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            // 격자 범위 내에 있는지 확인 (1-based index)
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                sb.append(dir[i]);
                dfs(nx, ny, dis + 1, sb);
                sb.deleteCharAt(sb.length() - 1); // 백트래킹 (원상복구)
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        // 시작 지점에서 도달 가능한지 1차 검증
        int shortestPath = Math.abs(x - r) + Math.abs(y - c);
        if (k < shortestPath || (k - shortestPath) % 2 != 0) {
            return "impossible";
        }
        
        dfs(x, y, 0, new StringBuilder());
        
        return answer == null ? "impossible" : answer;
    }
}