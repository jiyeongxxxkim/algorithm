import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] room = new int[1000];
        int[][] book = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            String[] b = book_time[i]; 
            
             
            book[i][0] = Integer.parseInt(b[0].split(":")[0])*60+Integer.parseInt(b[0].split(":")[1]);
            book[i][1] = Integer.parseInt(b[1].split(":")[0])*60+Integer.parseInt(b[1].split(":")[1]);
        }
        
        
        Arrays.sort(book, (a,b)->{
            return a[0]-b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] b:book){
            if(pq.isEmpty())pq.add((b[1]+10));
            else{
                if(pq.peek()<=b[0]){
                    pq.poll();
                    pq.add((b[1]+10));
                } 
                else{
                    pq.add((b[1]+10));
                }
            }
        }
        answer = pq.size();
        
        return answer;
    }
}