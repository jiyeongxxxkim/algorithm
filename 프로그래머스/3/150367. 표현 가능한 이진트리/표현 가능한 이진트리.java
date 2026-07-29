import java.util.*;
class Solution {
    boolean chk;
    int tofull(int size){
        int idx = 0;
        for(int i=0;;i++){
            double fullsize = Math.pow(2,i)-1;
            if(size<=fullsize)return (int)fullsize;
        }
    }
    void isValid(String s, int start, int end) {
        if (!chk || start >= end) return;
        int mid = (start + end) / 2;

        if (s.charAt(mid) == '0') {
            if (hasOne(s, start, mid - 1) || hasOne(s, mid + 1, end)) {
                chk = false; 
                return;
            }
        }

        isValid(s, start, mid - 1);
        isValid(s, mid + 1, end);
    }
    boolean hasOne(String s, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '1') return true;
        }
        return false;
    }
    public int[] solution(long[] numbers) {
        
        int[] answer = new int[numbers.length];
        
        for(int j=0;j<numbers.length;j++){
            String result = Long.toBinaryString(numbers[j]);
            int size = result.length();
            int fillsize = tofull(size)-size;
            for(int i=0;i<fillsize;i++){
                result = "0"+result;
            }    
            chk = true;
            isValid(result, 0, result.length()-1);
            if(chk)answer[j] = 1;
            else answer[j] = 0;
        }
        
        return answer;
    }
}