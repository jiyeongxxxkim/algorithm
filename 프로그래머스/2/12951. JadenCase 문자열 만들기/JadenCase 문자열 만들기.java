import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean chk = true;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' '){
                answer += " ";
                chk = true;
                continue;
        }else if(chk&&!Character.isDigit(ch)){
                answer+=String.valueOf(ch).toUpperCase();
            }else if(Character.isDigit(ch)){
                answer += ch;
            }else{
                answer += String.valueOf(ch).toLowerCase();
            }
            chk = false;
        
        } 
        return answer;
    }
}