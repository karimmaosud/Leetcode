class Solution {
  public boolean find132pattern(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int maxRight = Integer.MIN_VALUE;
    for(int i = nums.length - 1; i >= 0; i--){
      if(stack.isEmpty() || nums[i] <= stack.peek()){
        if(maxRight > nums[i]){
          return true;
        }
        stack.push(nums[i]);
        continue;
      }
      maxRight = Integer.MIN_VALUE;
      while(!stack.isEmpty() && nums[i] > stack.peek()){
        maxRight = Math.max(maxRight, stack.pop());
      }
      stack.push(nums[i]);
    }
    return false;
  }
}
