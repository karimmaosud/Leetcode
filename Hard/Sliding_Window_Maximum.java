class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 0){
      return new int[0];
    }
    int [] res = new int[nums.length - k + 1];
    Deque<Integer> dq = new LinkedList<>();

    for(int i = 0; i < k; i++){
      while(!dq.isEmpty() && nums[i] > dq.getLast()){
        dq.removeLast();
      }
      dq.addLast(nums[i]);
    }
    res[0] = dq.getFirst();
    for(int i = k; i < nums.length; i++){

      if(nums[i - k] == dq.getFirst()){
        dq.removeFirst();
      }

      while(!dq.isEmpty() && nums[i] > dq.getLast()){
        dq.removeLast();
      }

      dq.addLast(nums[i]);
      res[i - k + 1] = dq.getFirst();
    }
    return res;
  }
}