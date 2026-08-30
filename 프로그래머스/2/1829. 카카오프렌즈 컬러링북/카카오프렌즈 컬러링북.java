import java.util.*;
class Solution {
    int m, n;
    int[][] picture;
    boolean[][] visited;
    int bfs(int[] start, int val){
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int count = 1;
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            for(int i=0;i<4;i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nr>=0&&nr<m&&nc>=0&&nc<n){
                    if(!visited[nr][nc]&&picture[nr][nc]==val){
                        visited[nr][nc] = true;
                        count++;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.m = m;
        this.n = n;
        this.picture = picture.clone();
        visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0&&!visited[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(new int[]{i, j}, picture[i][j]));
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}