import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Deque<Character> stk = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        
        for(char ch : arr){
            if(stk.isEmpty()||stk.peek()!=ch){
                stk.push(ch);
            }else{
                stk.pop();
            }
        }
        if(stk.isEmpty())return 1;
        else return 0;
    }
}