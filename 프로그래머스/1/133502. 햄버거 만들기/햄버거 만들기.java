import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        ArrayList<Integer> arr= new ArrayList<>();

        for(int in:ingredient){
            arr.add(in);
            if(arr.size()>=4){
                if(arr.get(arr.size()-1)==1&&arr.get(arr.size()-2)==3&&arr.get(arr.size()-3)==2&&arr.get(arr.size()-4)==1){
                    answer++;
                    for(int i=0;i<4;i++){
                        arr.remove(arr.size()-1);
                    }
                }
            }
        }
        return answer;
    }
}