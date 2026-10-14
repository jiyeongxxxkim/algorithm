import java.util.*;
class Solution {
    ArrayList<int[]> combo = new ArrayList<>();
    int[][] list;
    int[] percent;
    void dfscombo(int n, int depth, int st, int[] arr){
        if(depth==n/2){
            combo.add(arr.clone());
            return;
        }
        for(int i=st;i<n;i++){
            arr[depth] = i;
            dfscombo(n, depth+1, i+1, arr);
        }
    }
    void getsum(int i, int n, int[][] dice, int[] com, int depth, int sum){
        if(depth==n/2){
            list[i][sum]++;
            return;
        }
        
        for(int j=0;j<6;j++){
            sum += dice[com[depth]][j];
            getsum(i, n, dice, com, depth+1, sum);
            sum -= dice[com[depth]][j];
        }
    }
    void getcount(int i){
        int bindex = combo.size() - 1 - i;
        
        int[] bPrefix = new int[501];
        bPrefix[0] = list[bindex][0];
        for (int j = 1; j <= 500; j++) {
            bPrefix[j] = bPrefix[j - 1] + list[bindex][j];
        }
        
        int wins = 0;
        
        for (int scoreA = 1; scoreA <= 500; scoreA++) {
            if (list[i][scoreA] > 0) {
                wins += list[i][scoreA] * bPrefix[scoreA - 1];
            }
        }
        
        percent[i] = wins;
    }
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int[] answer = new int[n/2];
        
        int[] arr = new int[n/2];
        dfscombo(n, 0, 0, arr);

        list = new int[combo.size()][501];
        for(int i=0;i<combo.size();i++){
            int sum = 0;
            getsum(i, n, dice, combo.get(i), 0, sum);
        }
        
        percent = new int[combo.size()];
        for(int i=0;i<combo.size();i++){
            getcount(i);
        }
        int maxval = -1;
        int maxidx = -1;
        for(int i=0;i<combo.size();i++){
            if(percent[i]>maxval){
                maxidx = i;
                maxval = percent[i];
            }
        }
        for(int i=0;i<n/2;i++){
            answer[i] = combo.get(maxidx)[i]+1;
        }
        return answer;
    }
}