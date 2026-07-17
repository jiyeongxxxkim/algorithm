import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        if (x == y) return 0;
        
        int[] visited = new int[y + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(x);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
              
            // 가능한 3가지 연산 후보
            int[] nextValues = {cur + n, cur * 2, cur * 3};
            
            for (int next : nextValues) {
                if (next == y) return visited[cur] + 1; // 목표 도달 시 즉시 반환
                
                // 범위 내에 있고, 아직 방문하지 않은 숫자라면
                if (next < y && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }
        
        return -1; // y를 만들 수 없는 경우
    }
}