import java.util.*;
class Solution {
    int n, m;
    ArrayList<Integer> area = new ArrayList<>();
    boolean[][] visited;
    int[][] maps_arr;
    int bfs(int curx, int cury, int sum){
        sum = maps_arr[curx][cury];
        
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int ntx = curx+dx[i];
            int nty = cury+dy[i];
            if(ntx>=0&&nty>=0&&ntx<n&&nty<m){
                if(!visited[ntx][nty]){
                    visited[ntx][nty] = true;
                    sum += bfs(ntx, nty, sum);
                }
            }
        }
        return sum;
        
        
    }
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        maps_arr = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='X'){
                    maps_arr[i][j] = -1;
                    visited[i][j] = true;
                }
                else maps_arr[i][j] = (maps[i].charAt(j)-'0');
            }
        }
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    area.add(bfs(i, j, 0));
                }
            }
        }
        
        int[] answer;
        if(area.size()==0){
          return new int[]{-1};  
        } 
        
        answer = new int[area.size()];
        
        Collections.sort(area);
        for(int i=0;i<answer.length;i++){
            answer[i] = area.get(i);
        }
        return answer;
    }
}