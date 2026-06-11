import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        ArrayList<double[]> failsco = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[N];

        for (int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0)+1);
        }
        Map<Integer, Integer> totalmap = new HashMap<>();
        int total = stages.length;
        for(int i=1;i<=N;i++){
            totalmap.put(i, total);
            total -= map.getOrDefault(i,0);
        }


        for(int i=1;i<=N;i++){
            double fail = 0.0;
            if(totalmap.getOrDefault(i,0)==0||map.getOrDefault(i,0)==0){
                fail = 0.0;
            }else{
                fail = (double)map.get(i)/totalmap.get(i);
            }
            failsco.add(new double[]{i, fail});
        }


        failsco.sort((a,b)->{
            if(Double.compare(a[1],b[1])==0){
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(b[1], a[1]);
        });
        
        int index = 0;
        for (double[] i : failsco) {
            result[index++] = (int)i[0];
        }

        answer = result;
        return answer;
    }
}