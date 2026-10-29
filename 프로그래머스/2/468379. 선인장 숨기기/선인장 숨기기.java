import java.util.*;
class Solution {
    int[] result = new int[2];
    boolean check(int m, int n, int h, int w, int[][] drops, int mid, int[] prefix) {
        Arrays.fill(prefix, 0);
        for (int i = 0; i < mid; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            prefix[r * n + c] = 1;
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int idx = r * n + c;       
                int currentVal = prefix[idx];
                int up = (r > 0) ? prefix[(r - 1) * n + c] : 0;
                int leftVal = (c > 0) ? prefix[r * n + (c - 1)] : 0;
                int upLeft = (r > 0 && c > 0) ? prefix[(r - 1) * n + (c - 1)] : 0;
                
                prefix[idx] = currentVal + up + leftVal - upLeft;
                
                if (r >= h - 1 && c >= w - 1) {
                    int topR = r - h; 
                    int topC = c - w; 
                    
                    int areaSum = prefix[idx];
                    if (topR >= 0) areaSum -= prefix[topR * n + c];
                    if (topC >= 0) areaSum -= prefix[r * n + topC];
                    if (topR >= 0 && topC >= 0) areaSum += prefix[topR * n + topC];
                    
                    if (areaSum == 0) {
                        result[0] = topR + 1;
                        result[1] = topC + 1;
                        return true; 
                    }
                }
            }
        }
        return false;
    }
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int t = drops.length;
        int left = 0;
        int right = t;
        
        int[] prefix = new int[m * n];
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(m, n, h, w, drops, mid, prefix)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}