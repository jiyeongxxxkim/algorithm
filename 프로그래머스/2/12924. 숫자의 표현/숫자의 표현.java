import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = 1;
        int sum = 1;
        while(left<=right&&right<=n){
            if(sum<n){
                right++;
                sum+=right;
            }else if(sum>n){
                sum-=left;
                left++;
            }else{
                answer++;
                right++;
                sum+=right;
            }
        }
        return answer;
    }
}