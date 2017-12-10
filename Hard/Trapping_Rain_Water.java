class Solution{
  class IntegerWrapper{
    int value;
  }
  public int trap(int[] height){
    if(height.length == 0){
      return 0;
    }
    int n = height.length;
    int i = 0;
    int j = n - 1;
    while(i < n && height[i] == 0){
      i++;
    }
    while(j >= 0 && height[j] == 0){
      j--;
    }
    int res = 0;
    while(i < j){
      int min = Math.min(height[i], height[j]);
      IntegerWrapper steps = new IntegerWrapper();
      if(min == height[i]){
        res += walk(i, j, 1, height, steps);
        i += steps.value;
      }else{
        res += walk(j, i, -1, height, steps);
        j += steps.value;
      }
    }
    return res;
  }
  private int walk(int x, int y, int inc, int[] height, IntegerWrapper steps){
    int x_runner = x + inc;
    int res = 0;
    while(x_runner != y && height[x_runner] <= height[x]){
      res += Math.abs(height[x_runner] - height[x]);
      x_runner += inc;
    }
    steps.value = x_runner - x;
    return res;
  }
}