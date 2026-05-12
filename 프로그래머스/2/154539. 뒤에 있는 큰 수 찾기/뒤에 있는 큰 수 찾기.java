import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Deque<int[]> stk = new ArrayDeque<>();
        int[] answer = new int[numbers.length];
        
        int index = 0;
        for(int i=0;i<numbers.length;i++){
            int number = numbers[i];
            while(!stk.isEmpty()&&stk.peek()[0]<number){
                
                answer[stk.pop()[1]] = number;
            }
            stk.push(new int[]{number,i});
            
        }
        int size = stk.size();
        for(int i=0;i<size;i++){
            answer[stk.pop()[1]] = -1;
        }
        
        
        return answer;
    }
}