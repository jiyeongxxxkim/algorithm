import java.util.*;
class Solution {
    public boolean istrue(String str){
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stk.push(ch);
            }else{
                if(stk.isEmpty())return false;
                char popch = stk.pop();
                if(ch==')'&&popch!='(')return false;
                if(ch=='}'&&popch!='{')return false;
                if(ch==']'&&popch!='[')return false;
            }
        }
        return stk.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        if(s.length()%2==1)return 0;
        
        String doubles = s+s;
        
        for(int i=0;i<len;i++){
            String chkstr = doubles.substring(i, i+len);
            if(istrue(chkstr))answer++;
        } 
        
        return answer;
    }
}