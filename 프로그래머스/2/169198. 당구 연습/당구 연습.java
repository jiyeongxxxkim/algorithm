class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minDistance = Integer.MAX_VALUE;
            
            // 1. 위쪽 벽에 맞는 경우 (y = n에 대해 대칭)
            // 단, x좌표가 같고 목표 공이 시작 공보다 위에 있으면 벽보다 공에 먼저 맞으므로 제외
            if (!(startX == targetX && startY < targetY)) {
                int dist = getDistance(startX, startY, targetX, n + (n - targetY));
                minDistance = Math.min(minDistance, dist);
            }
            
            // 2. 아래쪽 벽에 맞는 경우 (y = 0에 대해 대칭)
            // 단, x좌표가 같고 목표 공이 시작 공보다 아래에 있으면 제외
            if (!(startX == targetX && startY > targetY)) {
                int dist = getDistance(startX, startY, targetX, -targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 3. 왼쪽 벽에 맞는 경우 (x = 0에 대해 대칭)
            // 단, y좌표가 같고 목표 공이 시작 공보다 왼쪽에 있으면 제외
            if (!(startY == targetY && startX > targetX)) {
                int dist = getDistance(startX, startY, -targetX, targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 4. 오른쪽 벽에 맞는 경우 (x = m에 대해 대칭)
            // 단, y좌표가 같고 목표 공이 시작 공보다 오른쪽에 있으면 제외
            if (!(startY == targetY && startX < targetX)) {
                int dist = getDistance(startX, startY, m + (m - targetX), targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            answer[i] = minDistance;
        }
        
        return answer;
    }
    
    // 점과 점 사이의 거리의 제곱을 구하는 헬퍼 메서드
    private int getDistance(int x1, int y1, int x2, int y2) {
        return (int)(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}