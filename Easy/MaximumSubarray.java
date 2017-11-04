class Solution {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] > nums[i] + currentSum){
        currentSum = nums[i];
      }else{
        currentSum += nums[i];
      }
      maxSum = Math.max(currentSum, maxSum);
    }
    return maxSum;
  }
}
