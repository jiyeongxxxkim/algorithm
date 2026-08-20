import java.util.*;
class Solution {
    int[][] distance;
    int[][] area;
    int bfs(int[] st, int[] end){
        int[][] count = new int[area.length][area[0].length];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        boolean[][] visited = new boolean[area.length][area[0].length];
        visited[st[0]][st[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(st);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            int cnt = count[curx][cury];
            for(int i=0;i<4;i++){
                int nx = curx+dx[i];
                int ny = cury+dy[i];
                if(nx>=0&&nx<count.length&&ny>=0&&ny<count[0].length){
                    if(!visited[nx][ny]&&count[nx][ny]==0&&area[nx][ny]!=1){
                        count[nx][ny] = cnt+1;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        int ex = end[0];
        int ey = end[1];
        return count[ex][ey];
    }
    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length();
        int[] prichk = new int[panels.length+1];
        int[] elvpo = new int[2];
        for(int[]s:seqs){
            int a = s[0]-1;
            int b = s[1]-1;
            prichk[b] |= (1<<a);
        }
        area = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char chk = grid[i].charAt(j);
                if(chk=='.')area[i][j] = 0;
                else if(chk=='@'){
                    area[i][j] = 2;
                    elvpo[0] = i;
                    elvpo[1] = j;
                }
                else area[i][j] = 1;
                
            }
        }
        distance = new int[panels.length][panels.length];
        int[] elv = new int[panels.length];
        for(int i=0;i<panels.length;i++){
            elv[i] = bfs(elvpo, new int[]{panels[i][1]-1,panels[i][2]-1});
        }
        for(int i=0;i<panels.length;i++){
            for(int j=0;j<panels.length;j++){
                if(i!=j&&distance[i][j]==0){
                    if(panels[i][0]==panels[j][0]){
                        distance[i][j] = bfs(new int[]{panels[i][1]-1,panels[i][2]-1}, new int[]{panels[j][1]-1,panels[j][2]-1});
                        distance[j][i] = distance[i][j];
                    }else{
                        distance[i][j] = elv[i]+elv[j]+Math.abs(panels[i][0]-panels[j][0]);
                        distance[j][i] = distance[i][j];
                    }
                }
            }
        }
        
        int targetbit = (1<<panels.length)-1;

        // 2. 우선순위 큐: 누적 시간이 '짧은' 순서대로 먼저 탐색하도록 정렬
        // 배열 안의 데이터: {현재 서 있는 패널 인덱스, 켜진 패널들의 비트 합, 누적 시간}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);

        // 3. 2차원 방문 체크판: [켜진 패널 비트 상태][현재 위치]
        boolean[][] visited = new boolean[1 << panels.length][panels.length];

        // 4. 시작점 세팅 (힌트 2번의 핵심!)
        // 기술자는 무조건 1번 패널(인덱스 0) 위치에서 시작합니다.
        // 0번 패널을 바로 켤 수 있는지(선행 조건이 없는지) 확인합니다.
        if(prichk[0] ==0){
            pq.add(new int[]{0, 1<<0,0});
        }else{
            pq.add(new int[]{0,0,0});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curpo = cur[0];
            int curbit = cur[1];
            int curtime = cur[2];
            
            if(curbit==targetbit)return curtime;  
            
            if(visited[curbit][curpo])continue;
            visited[curbit][curpo] = true;
            
            for(int nx = 0;nx<panels.length;nx++){
                if((curbit&(1<<nx))!=0)continue;
                if((curbit&prichk[nx])!=prichk[nx])continue;
                
                int nxbit = curbit | (1<<nx);
                int nxtime = curtime + distance[curpo][nx];
                
                pq.add(new int[]{nx, nxbit, nxtime});
            }
            
        }
        return 0; 
    }
}