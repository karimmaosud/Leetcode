import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  class Pair{
    int num, size;
    Pair(int num){
      this.num = num;
      this.size = 1;
    }
    Pair(int num, int size){
      this.num = num;
      this.size = size;
    }
    void increaseSize(){
      this.size++;
    }
  }
  class PQComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2){
      int diff = p1.num - p2.num;
      return diff != 0 ? diff : p1.size - p2.size;
    }
  }
  public boolean isPossible(int[] nums) {
    if(nums.length == 0){
      return false;
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(new PQComparator());
    pq.add(new Pair(nums[0]));
    for(int i = 1; i < nums.length; i++){
      if(pq.isEmpty()){
        pq.add(new Pair(nums[i]));
        continue;
      }
      Pair top = pq.poll();
      if(nums[i] == top.num + 1){
        pq.add(new Pair(nums[i], top.size + 1));
      }else if(nums[i] == top.num){
        pq.add(top);
        pq.add(new Pair(nums[i]));
      }else{
          if(top.size < 3){
            return false;
        }
        i--;
      }
    }
    while(!pq.isEmpty()){
      if(pq.poll().size < 3){
        return false;
      }
    }
    return true;
  }
}


