import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer, int[]> hmap = new TreeMap<>();
        int maxtime = 60*23+59;
        ArrayList<Integer> result = new ArrayList<>();
        for(String record:records){
            String[] carrecord = record.split(" ");
            int time = Integer.parseInt(carrecord[0].split(":")[0])*60+Integer.parseInt(carrecord[0].split(":")[1]);
            int number = Integer.parseInt(carrecord[1]);
            String mod = carrecord[2];
            if(mod.equals("IN")){
                if(hmap.containsKey(number)){
                    int oritime = hmap.get(number)[1];
                    hmap.put(number, new int[]{time, oritime});
                }else{
                    hmap.put(number, new int[]{time, 0});   
                }
            }else{
                int intime = hmap.get(number)[0];
                int oritime = hmap.get(number)[1];
                hmap.put(number, new int[]{-1, (oritime+time-intime)});
            }
        }
        for(int number:hmap.keySet()){
            int intime = hmap.get(number)[0];
            int oritime = hmap.get(number)[1];
            if(intime!=-1){
                hmap.put(number, new int[]{-1, oritime+maxtime-intime});
            }
            int totaltime = hmap.get(number)[1];
            int addfee = 0;
            if(totaltime>fees[0]){
                addfee = (int)Math.ceil((double)(totaltime - fees[0]) / fees[2]) * fees[3];
            }
            // System.out.println(number +" : "+hmap.get(number)[0]+"/"+hmap.get(number)[1]+" = "+addfee);
            result.add(fees[1]+addfee);
            
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}