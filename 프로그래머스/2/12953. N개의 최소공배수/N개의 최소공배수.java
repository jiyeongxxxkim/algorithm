import java.util.*;
class Solution {
    public int gcp(int a, int b){
        if(b==0)return a;
        return gcp(b, a%b);
    }
    public int lcd(int a, int b){
        return a*b/gcp(a,b);
    }
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        
        if(arr.length==1)return arr[0];
        answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer = lcd(answer, arr[i]);
        }
        return answer;
    }
}