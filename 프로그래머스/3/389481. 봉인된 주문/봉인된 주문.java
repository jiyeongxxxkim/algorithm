import java.util.*;
class Solution {
    long stringToLong(String s) {
        long index = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            index = index * 26 + val;
        }
        return index;
    }
    public String solution(long n, String[] bans) {
        long[] bansint = new long[bans.length];
        long rn = n;
        for(int i=0;i<bans.length;i++){
            bansint[i] = stringToLong(bans[i]);
        }
        Arrays.sort(bansint);
        for(int i=0;i<bans.length;i++){
            if(rn>=bansint[i])rn++;
            else break;
        }
        
        StringBuilder sb = new StringBuilder();
    
        while (rn > 0) {
            rn--;
            long remainder = rn % 26;
            sb.append((char) ('a' + remainder));
            rn /= 26;
        }

        return sb.reverse().toString();
    }
}