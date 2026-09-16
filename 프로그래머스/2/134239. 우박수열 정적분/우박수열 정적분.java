import java.util.*;
class Solution {
    ArrayList<Integer> arr;
    double[] width;
    void inum(int i){
        arr.add(i);
        if(i==1){
            return;
        }
        if(i%2==0)inum(i/2);
        else inum(i*3+1);
    }
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        arr = new ArrayList<>();
        inum(k);    
        width = new double[arr.size()-1];
        for(int i=0;i<arr.size()-1;i++){
            width[i] = ((double)arr.get(i)+(double)arr.get(i+1))/2.0;
        }
        int n = arr.size()-1;
        for(int i=0;i<ranges.length;i++){
            int start = ranges[i][0];
            int end = n+ranges[i][1];
            double sum = 0.0;
            if(start>end)answer[i] = -1.0;
            else if(start==end)answer[i] = 0.0;
            else{
                for(int j=start;j<end;j++){
                    sum += (double)width[j];
                }answer[i] = sum;
            }
        }
        
        return answer;
    }
}