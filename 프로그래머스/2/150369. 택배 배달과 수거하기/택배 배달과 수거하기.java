class Solution {
    int n;
    int[] pick;
    int[] deli;
    int maxpick(int st){
        for(int i=st;i>=0;i--){
            if(pick[i]!=0)return i;
        }
        return -1;
    }
    int maxdeli(int st){
        for(int i=st;i>=0;i--){
            if(deli[i]!=0)return i;
        }
        return -1;
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        this.n = n;
        this.pick = pickups.clone();
        this.deli = deliveries.clone();
        
        int debox = 0;
        int pibox = 0;
        int start = n-1;
        while(maxdeli(start)!=-1||maxpick(start)!=-1){
            debox = cap;
            pibox = cap;
            
            int maxpick_idx = maxpick(start);
            int maxdeli_idx = maxdeli(start);
            start  = Math.max(maxpick_idx, maxdeli_idx);
            answer += Math.max(maxpick_idx+1, maxdeli_idx+1)*2;
            
            if(maxdeli_idx!=-1){
                for(int i=maxdeli_idx;i>=0&&debox>0;i--){
                    int box = Math.min(deli[i], debox);
                    deli[i] -= box;
                    debox -= box;
                }    
            }
            if(maxpick_idx!=-1){
                for(int i=maxpick_idx;i>=0&&pibox>0;i--){
                    int box = Math.min(pick[i], pibox);
                    pick[i] -= box;
                    pibox -= box;
                }    
            }
            
            
        }
        
        return answer;
    }
}