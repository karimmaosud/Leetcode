
import java.util.Arrays;

class Solution {
  public int leastInterval(char[] tasks, int n) {
    int [] count = new int [26];
    for(int i = 0; i < tasks.length; i++){
      count[tasks[i] - 'A']++;
    }
    Arrays.sort(count);
    int [] chunks = new int[count[count.length - 1]];
    int maxs = 0;
    for(int i = count.length - 1; i >= 0; i--){
      if(count[i] < count[25]){
        break;
      }
      maxs++;
    }
    for(int i = 0; i < chunks.length; i++){
      chunks[i] += maxs;
    }
    int idx = 0;
    for(int i = count.length - maxs - 1; i >= 0; i--){
      if(count[i] == 0){
        break;
      }
      for(int j = 0; j < count[i]; j++){
        chunks[idx++]++;
        if(idx >= chunks.length - 1){
          idx = 0;
        }
      }
    }
    int res = 0;
    for(int i = 0; i < chunks.length - 1; i++){
      if(chunks[i] < n + 1){
        chunks[i] += (n + 1 - chunks[i]);
      }
      res += chunks[i];
    }
    res += chunks[chunks.length - 1];
    return res;
  }
}