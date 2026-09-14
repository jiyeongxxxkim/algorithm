import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0)return 5*cities.length;
        List<String> cache = new LinkedList<>();
        for(String ci:cities){
            String city = ci.toLowerCase();
            if(cache.contains(city)){
                cache.remove(city);
                answer += 1;
            }else{
                if(cache.size()>=cacheSize){
                    cache.remove(0);
                }answer += 5;
            }cache.add(city);
        }
        return answer;
    }
}