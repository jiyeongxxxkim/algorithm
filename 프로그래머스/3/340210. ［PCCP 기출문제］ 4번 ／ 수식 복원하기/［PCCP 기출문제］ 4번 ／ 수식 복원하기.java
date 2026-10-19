import java.util.*;
class Solution {
    boolean cal(int a, int b, String op, int c){
        if(op.equals("+")){
            if((a+b)==c)return true;
        }
        else if(op.equals("-")){
            if((a-b)==c)return true;
        }
        return false;
    }
    public String[] solution(String[] expressions) {
        int maxnum = 0;
        int count = 0;
        boolean[] base = new boolean[10];
        int n = expressions.length;
        
        for(String ex:expressions){
            if(ex.contains("X"))count++;
            for(int i=0;i<ex.length();i++){
                if(Character.isDigit(ex.charAt(i)))maxnum = Math.max(maxnum, ex.charAt(i)-'0');
            }
        }
        maxnum++;
        String[] answer = new String[count];
        for(int i=maxnum;i<10;i++)base[i] = true;
        
        for(int i=2;i<10;i++){
            if(!base[i])continue;
            for(String ex:expressions){
                if(ex.contains("X"))continue;
                
                String[] sp = ex.split(" ");
                String a = sp[0];
                String b = sp[2];
                String op = sp[1];
                String c = sp[4];
                
                int inta = Integer.parseInt(a, i);
                int intb = Integer.parseInt(b, i);
                int intc = Integer.parseInt(c, i);
                
                if(!cal(inta, intb, op, intc)){
                    base[i] = false;
                    break;
                }
                
            }
        }

        StringBuilder sb;
        int idx = 0;
        for(String ex:expressions){
            if(!ex.contains("X"))continue;
            sb = new StringBuilder();
            int baseresult = -1;
            String calresult = "";
            boolean chk = true;
            String[] sp = ex.split(" ");
            String a = sp[0];
            String b = sp[2];
            String op = sp[1];
            sb.append(a).append(" ").append(op).append(" ").append(b).append(" = ");
            for(int i=2;i<10;i++){
                if(!base[i])continue;
                baseresult = i;
                
                int inta = Integer.parseInt(a, i);
                int intb = Integer.parseInt(b, i);
                
                if(op.equals("+")){
                    if(calresult.equals(""))calresult = Integer.toString((inta+intb), i);
                    else{
                        if(!Integer.toString((inta+intb), i).equals(calresult)){
                            sb.append("?");
                            chk = false;
                            break;
                        }
                    }
                }else{
                    if(calresult.equals(""))calresult = Integer.toString((inta-intb), i);
                    else{
                        if(!Integer.toString((inta-intb), i).equals(calresult)){
                            sb.append("?");
                            chk = false;
                            break;
                        }
                    }
                }
            }
            if(chk)sb.append(calresult);
            
            answer[idx++] = sb.toString();
        }
        
        
        return answer;
    }
}