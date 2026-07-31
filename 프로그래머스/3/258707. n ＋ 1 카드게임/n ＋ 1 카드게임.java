import java.util.*;
class Solution {
    int coin;
    Set<Integer> oset;
    Set<Integer> pset;
    int hap;
    boolean ochk(){
        for(int o:oset){
            if(oset.contains(hap-o)){
                oset.remove(o);
                oset.remove(hap-o);
                return true;
            }
        }return false;
    }
    boolean opchk(){
        for(int o:oset){
            if(pset.contains(hap-o)){
                oset.remove(o);
                pset.remove(hap-o);
                return true;
            }
        }return false;
    }
    boolean pchk(){
        for(int p:pset){
            if(pset.contains(hap-p)){
                pset.remove(p);
                pset.remove(hap-p);
                return true;
            }
        }return false;
    }
    public int solution(int coin, int[] cards) {
        
        int answer = 0;
        this.coin = coin;
        oset = new HashSet<>();
        pset = new HashSet<>();
        int n = cards.length;
        hap = n+1;
        int osize = n/3;
        for(int i=0;i<n/3;i++)oset.add(cards[i]);
        
        for(int i=1;i<(n-osize)/2+1;i++){
            pset.add(cards[osize+(i-1)*2]);
            pset.add(cards[osize+(i-1)*2+1]);
            if(ochk())continue;
            if(opchk()){
                if(coin>0){
                    coin--;
                    continue;
                }else{
                    return i;
                }
            }if(pchk()){
                if(coin>=2){
                    coin -=2;
                    continue;
                }else{
                    return i;
                }
            }
            return i;
        }
        
        return (n-osize)/2+1;
    }
}