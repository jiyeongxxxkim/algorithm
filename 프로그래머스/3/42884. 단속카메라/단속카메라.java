import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b)->{
            return a[1]-b[1];
        });
        int camera = routes[0][1];
        int count = 1;
        for(int i=0;i<routes.length;i++){
            if(routes[i][0]>camera){
                count++;
                camera = routes[i][1];
            }
        }
        
        return count;
    }
}