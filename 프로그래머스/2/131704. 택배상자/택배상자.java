import java.util.*;
class Solution {
    public int solution(int[] order) {
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= order.length; i++) {
            q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()&&count<order.length) {
            if(q.peek()==order[count]) {
                q.poll();
                count++;
            }else if(!dq.isEmpty()&&dq.peek()==order[count]){
                dq.pop();
                count++;
            }else{
                dq.push(q.poll());
            }
        }
        while(!dq.isEmpty()&&count<order.length){
            if(dq.peek()==order[count]){
                dq.pop();
                count++;
            }else{
                return count;
            }
        }
         
        return count;
    }
}