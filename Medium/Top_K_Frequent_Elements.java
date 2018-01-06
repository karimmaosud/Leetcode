import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      if(!map.containsKey(nums[i])){
        map.put(nums[i], 0);
      }
      map.put(nums[i], map.get(nums[i] + 1));
    }
    List<Integer>[] bucket = new List[nums.length + 1];
    for(Entry<Integer, Integer> entry: map.entrySet()){
      int count = entry.getValue();
      int num = entry.getKey();
      if(bucket[count] == null){
        bucket[count] = new LinkedList<>();
      }
      bucket[count].add(num);
    }
    List<Integer> list = new LinkedList<>();
    for(int i = nums.length; i > 0; i--){
      if(bucket[i] != null){
        for(int num: bucket[i]){
          list.add(num);
          if(list.size() == k){
            return list;
          }
        }
      }
    }
    return list;
  }
}


