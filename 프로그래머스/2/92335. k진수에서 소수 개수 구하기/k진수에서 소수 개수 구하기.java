import java.util.*;
class Solution {
    public boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
    public int solution(int n, int k) {
        
        // boolean[] isprime = new boolean[n+1];
        // for(int i=2;i<=n;i++){
        //     isprime[i] = true;
        // }
        // for(int i=2;i*i<=n;i++){
        //     if(isprime[i]){
        //         for(int j=i*i;j<=n;j+=i){
        //             isprime[j] = false;
        //         }
        //     }
        // }
        
        String basek = Integer.toString(n, k);
        String[] strsplit = basek.split("0");
        int answer = 0;
        
        for(String s:strsplit){
            if(s.equals(""))continue;
            if(isPrime(Long.parseLong(s)))answer++;
        }
        return answer;
    }
}