class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    return findKthSmallest(nums, k);
  }
  private int findKthSmallest(int [] nums, int k){
    int low = 0;
    int high = nums[nums.length - 1];
    while(low <= high){
      int mid = (low + high) / 2;
      if(getCount(nums, mid) >= k){
        high = mid - 1;
      }else{
        low = mid + 1;
      }
    }
    return low;
  }
  private int getCount(int [] nums, int k){
    int res = 0;
    for(int i = 1; i < nums.length; i++){
      res += (i - pairCount(nums, i, k));
    }
    return res;
  }
  private int pairCount(int[] nums, int i, int k){
    int low = 0;
    int high = i - 1;
    while(low <= high){
      int mid = (low + high) / 2;
      if(nums[i] - nums[mid] <= k){
        high = mid - 1;
      }else{
        low = mid + 1;
      }
    }
    return low;
  }
}
