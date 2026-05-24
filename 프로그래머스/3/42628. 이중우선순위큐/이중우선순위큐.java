import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int[] answer = new int[2];
        
        for(String op:operations){
            char ch = op.charAt(0);
            int num = Integer.parseInt(op.substring(2));
            
            if(ch=='I'){
                tmap.put(num, tmap.getOrDefault(num,0)+1);
            }else if(ch=='D'&&num==1&&!tmap.isEmpty()){
                int maxkey = tmap.lastKey();
                if(tmap.get(maxkey)==1)tmap.remove(maxkey);
                else tmap.put(maxkey, tmap.get(maxkey)-1);
            }else if(ch=='D'&&num==-1&&!tmap.isEmpty()){
                int minkey = tmap.firstKey();
                if(tmap.get(minkey)==1)tmap.remove(minkey);
                else tmap.put(minkey, tmap.get(minkey)-1);
            }
        }
        
        if(!tmap.isEmpty()){
            answer[0] = tmap.lastKey();
            answer[1] = tmap.firstKey();
        }
        return answer;
    }
}