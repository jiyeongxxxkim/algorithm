import java.util.*;
class Solution {
    static int[][] map;
    static int max_x;
    static int max_y;
    static boolean[][] visited;
    static int[][] count;
    public void bfs(int[] ch){
        Queue<int[]> q = new LinkedList<>();
         
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        q.add(ch);
        visited[ch[0]][ch[1]] = true;
        count[ch[0]][ch[1]] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            
            for(int i=0;i<4;i++){
                int next_x = cur_x+dx[i];
                int next_y = cur_y+dy[i];
                if(next_x>0&&next_x<=max_x&&next_y>0&&next_y<=max_y){
                    if(!visited[next_x][next_y]&&map[next_x][next_y]==1){
                        visited[next_x][next_y] = true;
                        count[next_x][next_y] = count[cur_x][cur_y]+1;
                        q.add(new int[]{next_x, next_y});
                    }
                }
            }
        }
        
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        map = new int[102][102];
        max_x = 0;
        max_y = 0;
        for(int[] rect: rectangle){
            int stx = rect[0]*2;
            int sty = rect[1]*2;
            int enx = rect[2]*2;
            int eny = rect[3]*2;
            
            max_x = Math.max(max_x, enx);
            max_y = Math.max(max_y, eny);
            for(int x=stx;x<=enx;x++){
                for(int y=sty;y<=eny;y++){
                    if(map[x][y]==2)continue;
                    
                    if(x==stx||x==enx||y==sty||y==eny){
                        map[x][y] = 1;    
                    }else{
                        map[x][y] = 2;
                    }
                }
            }
        }
//         for(int i=0;i<=max_x;i++){
//             for(int j=0;j<=max_y;j++){
//                 if(map[i][j]==1){
//                     System.out.print(i+","+j+" ");        
//                 }
                

//             }System.out.println();
//         }
        
        visited = new boolean[102][102];
        count = new int[102][102];
        
        bfs(new int[]{characterX*2,characterY*2});
        
        // System.out.println(count[itemX*2][itemY*2]/2);
        answer = count[itemX*2][itemY*2]/2;
        
        return answer;
    }
}