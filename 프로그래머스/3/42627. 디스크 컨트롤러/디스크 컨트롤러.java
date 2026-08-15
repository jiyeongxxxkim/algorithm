import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)->{
           return a[0]-b[0]; 
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])return a[0]-b[0];
            return a[1]-b[1];
        });
        int answer = 0;  
        int count =0;
        int curtime=0;
        int jobindex = 0;
        while(count<jobs.length){
            while(jobindex<jobs.length&&jobs[jobindex][0]<=curtime)pq.add(jobs[jobindex++]);
            if(pq.isEmpty()){
                curtime = jobs[jobindex][0];
            }else{
                int[] cur = pq.poll();
                answer += (curtime+cur[1]-cur[0]);
                curtime += cur[1];
                count++;
            }
        }
        answer /= jobs.length;
        
        return answer;
    }
}