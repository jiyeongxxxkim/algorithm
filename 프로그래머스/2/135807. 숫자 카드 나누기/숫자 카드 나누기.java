class Solution {
    int gcd(int a, int b){
        if(b==0)return a;
        else return gcd(b, a%b);
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        if(n>1){
            for(int i=1;i<n;i++){
                gcdA = gcd(gcdA, arrayA[i]);
                gcdB = gcd(gcdB, arrayB[i]);
            }   
        }
        boolean booA = true, booB = true;
        for(int i=0;i<n;i++){
            if(arrayB[i]%gcdA==0){
                booA = false;
                break;
            }
        }
        if(booA)answer = gcdA;
        for(int i=0;i<n;i++){
            if(arrayA[i]%gcdB==0){
                booB = false;
                break;
            }
        }
        if(booB)answer = Math.max(answer, gcdB);
        
        return answer;
    }
}