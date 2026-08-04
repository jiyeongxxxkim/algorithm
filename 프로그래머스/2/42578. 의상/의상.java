import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> clo = new HashMap<>();
        for(String[] str :clothes){
            clo.put(str[1], clo.getOrDefault(str[1], 0)+1);
        } 
        int total = 1;
        for(String k:clo.keySet()){
            total*=(clo.get(k)+1);
        }
        answer = total-1;
        
        return answer;
    }
}