import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] file = new String[files.length][3];
        for(int idx = 0;idx<files.length;idx++){
            String f = files[idx];
            boolean headchk = true;
            StringBuilder sb = new StringBuilder();
            String head = "";
            String body = "";
            for(int i=0;i<f.length();i++){
                char ch = f.charAt(i);
                if(headchk){
                    if(Character.isDigit(ch)){
                        headchk = false;
                        head = sb.toString().toLowerCase();
                        sb.setLength(0);
                        sb.append(ch);    
                    }else{
                        sb.append(ch);
                    }
                }else if(!Character.isDigit(ch)){
                    body = sb.toString();
                    break;
                }else{
                    sb.append(ch);
                }
            }
            if(body.equals(""))body = sb.toString();
            file[idx][0] = idx+"";
            file[idx][1] = head;
            file[idx][2] = body;
        }
        
        Arrays.sort(file, (a,b)->{
           if(a[1].equals(b[1])){
               if(Integer.parseInt(b[2])==Integer.parseInt(a[2])){
                   return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
               }else return Integer.parseInt(a[2])-Integer.parseInt(b[2]);
           } else return a[1].compareTo(b[1]);
        });
        
        for(int i=0;i<files.length;i++){
            answer[i] = files[Integer.parseInt(file[i][0])];
        }
        return answer;
    }
}