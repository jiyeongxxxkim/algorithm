import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        if(s.length()%2!=0)return 0;
        Deque<Character> stk = new ArrayDeque<>();
        int idx = 0;
        stk.push(s.charAt(idx++));
        while(idx<s.length()){
            if(stk.isEmpty()){
                stk.push(s.charAt(idx++));
                continue;
            }
            if(s.charAt(idx)==stk.peek()){
                stk.pop();
                idx++;
            }else{
                stk.push(s.charAt(idx++));
            }
        }
        if(stk.size()>1){
            char c1 = stk.pop();
            if(c1==stk.peek())return 1;
            else stk.push(c1);
        }
        if(!stk.isEmpty())return 0;
        else return 1;
    }
}