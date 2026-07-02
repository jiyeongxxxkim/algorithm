import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // Map<String, Integer> wantmap = new HashMap<>();
        Map<String, Integer> dismap = new HashMap<>();
        
        for(int i=0;i<10;i++){
            dismap.put(discount[i], dismap.getOrDefault(discount[i],0)+1);
        }
        
        for(int i=0;(i+10)<=discount.length;i++){
            boolean chk = true;
            for(int j=0;j<want.length;j++){
                if(number[j]!=dismap.getOrDefault(want[j],0)){
                    chk = false;
                }
            }
            
            if(chk){
                // System.out.println(i);
                answer++;
            }
            if((i+10)<discount.length){
                dismap.put(discount[i], dismap.get(discount[i])-1);
                dismap.put(discount[i+10], dismap.getOrDefault(discount[i+10], 0)+1);
            }
        }
        
        return answer;
    }
}