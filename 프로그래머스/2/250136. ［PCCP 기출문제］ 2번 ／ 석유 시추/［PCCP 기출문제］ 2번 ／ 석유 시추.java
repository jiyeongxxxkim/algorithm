import java.util.*;
class Solution {
    int n, m;
    boolean[][] visited;
    int[][] landvalue;
    int[] oilSum;
    void bfs(int stx, int sty){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{stx, sty});
        visited[stx][sty] = true;
        int size = 0;
        Set<Integer> cols = new HashSet<>();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            size++;
            cols.add(cury);
            for(int i=0;i<4;i++){
                int ntx = curx+dx[i];
                int nty = cury+dy[i];
                if(ntx>=0&&nty>=0&&ntx<n&&nty<m){
                    if(landvalue[ntx][nty]==1&&!visited[ntx][nty]){
                        visited[ntx][nty] = true;
                        q.add(new int[]{ntx,nty});
                    }
                }
            }
        }for (int col : cols) {
            oilSum[col] += size;
        }
    }
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        landvalue = land;
        oilSum = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(landvalue[i][j]==1&&!visited[i][j])bfs(i,j);
            }
        }
        for (int sum : oilSum) {
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}