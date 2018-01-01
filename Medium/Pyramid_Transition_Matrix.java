import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  private Map<Long, Boolean> dp = new HashMap<>();
  public boolean pyramidTransition(String bottom, List<String> allowed) {
    int [][] chars = new int[7][7];
    initChars(allowed, chars); // checked
    int n = bottom.length(); // number of levels
    int [][] levels = new int [n][n];
    for(int i = 0; i < bottom.length(); i++){
      levels[n-1][i] = bottom.charAt(i) - 'A';   // fill last level by the bottom
    }
    return solve(levels, chars,0L, n-1, 0);
  }

  private void initChars(List<String> allowed, int[][] chars){
    for(String s: allowed){
      chars[s.charAt(0) - 'A'][s.charAt(1) - 'A'] |= (1 << (s.charAt(2) - 'A'));
    }
  }

  private boolean solve(int [][] levels, int[][] chars, Long num, int n, int idx){
    if(n == 0){
      return true;
    }

    if(idx == n){
      // process to upper level
      if(!dp.containsKey(num)){
        dp.put(num, solve(levels, chars, 0L, n - 1, 0));
      }
      return dp.get(num);
    }

    for(int i = 0; i < 7; i++){
      if((chars[levels[n][idx]][levels[n][idx + 1]] & (1 << i)) != 0){
        levels[n - 1][idx] = i;
        if(solve(levels, chars, num * 7 + i, n, idx + 1)){
          return true;
        }
      }
    }
    return false;
  }
}

