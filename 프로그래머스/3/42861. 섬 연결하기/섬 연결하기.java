import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a,b)->{
           return a[2]-b[2]; 
        });
        int[] parent = new int[n];
        for(int i=0;i<n;i++)parent[i] = i;
        
        for(int[] cost:costs){
            int min = Math.min(cost[0], cost[1]);
            int max = Math.max(cost[0], cost[1]);
            
            if(parent[min]!=parent[max]){
                int val = parent[max];
                for(int i=0;i<n;i++){
                    if(parent[i]==val)parent[i]=parent[min];
                }
                answer+=cost[2];
            }
        }
        return answer;
    }
}