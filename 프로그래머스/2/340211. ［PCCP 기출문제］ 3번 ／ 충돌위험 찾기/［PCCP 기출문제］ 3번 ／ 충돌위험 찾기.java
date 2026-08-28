import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = points.length+1;
        int m = points[0].length+1;
        List<int[]>[] course = new ArrayList[routes.length];
        
        for(int i=0;i<routes.length;i++){
            course[i] = new ArrayList<>();
            int start = routes[i][0]-1;
            int cr = points[start][0];
            int cc = points[start][1];
            course[i].add(new int[]{cr, cc});
            
            for(int j=1;j<routes[i].length;j++){
                int next = routes[i][j]-1;
                int nr = points[next][0];
                int nc = points[next][1];
                
                while(cr!=nr){
                    if(cr<nr)cr++;
                    else cr--;
                    course[i].add(new int[]{cr, cc});
                }
                while(cc!=nc){
                    if(cc<nc)cc++;
                    else cc--;
                    course[i].add(new int[]{cr, cc});
                }
            }
        }
        int maxtime = 0;
        for(List<int[]> c:course)maxtime = Math.max(maxtime, c.size());
        
        for(int t=0;t<maxtime;t++){
            int[][] map = new int[101][101];
            for(int i=0;i<routes.length;i++){
                if(t<course[i].size()){
                    int[] cou = course[i].get(t);
                    map[cou[0]][cou[1]]++;
                }
            }
            for(int i=1;i<101;i++){
                for(int j=1;j<101;j++){
                    if(map[i][j]>=2)answer++;
                }
            }
        }
        
        return answer;
    }
}