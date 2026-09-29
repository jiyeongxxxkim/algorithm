import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1pow = (long)Math.pow(r1,2);
        long r2pow = (long)Math.pow(r2,2);
        for(int i=1;i<=r2;i++){
            long ipow = (long)Math.pow(i,2);
            long maxy = (long)Math.floor(Math.sqrt(r2pow-ipow));
            long miny = 0;
            if(i<r1){
                miny = (long)Math.ceil(Math.sqrt(r1pow-ipow));
            }
            answer += (maxy - miny + 1);
        }
        return answer*4;
    }
}