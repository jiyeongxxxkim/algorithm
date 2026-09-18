import java.util.*;
class Solution {
    Map<String, ArrayList> hmap;
    void makesen(String[] infos, String sen, int depth, int sco){
        if(depth==4){
            hmap.computeIfAbsent(sen, k -> new ArrayList<>()).add(sco);    
            return;
        }
        makesen(infos, sen+infos[depth].substring(0,1), depth+1,sco);
        makesen(infos, sen+"-", depth+1, sco);
        
    }
    int getcount(ArrayList<Integer> arr, int qsco){
        int left = 0;
        int right = arr.size();
        while(left<right){
            int mid = (left+right)/2;
            if(arr.get(mid)>=qsco)right = mid;
            else left = mid+1;
        }return arr.size()-left;
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hmap = new HashMap<>();
        for(String i:info){
            String[] isplit = i.split(" ");
            int sco = Integer.parseInt(isplit[4]);
            makesen(isplit, "", 0, sco);
        }
        for(ArrayList<Integer> list : hmap.values()){
            Collections.sort(list);
        }
        for(int i=0;i<query.length;i++){
            String q = query[i];
            String[] qsplit = q.split(" and ");
            String finalq = qsplit[0].substring(0,1)+qsplit[1].substring(0,1)+qsplit[2].substring(0,1)+qsplit[3].substring(0,1);
            int idx = qsplit[3].indexOf(" ");
            int qsco = Integer.parseInt(qsplit[3].substring(idx+1));
            if(hmap.containsKey(finalq))answer[i] = getcount(hmap.get(finalq), qsco);
            else answer[i] = 0;
        }
        
        return answer;
    }
}