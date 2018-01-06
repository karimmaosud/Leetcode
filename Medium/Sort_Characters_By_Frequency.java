// Solution 1 - using priority queue.
import java.util.Map.Entry;
class Solution {
  class EntryComparator implements Comparator<Entry<Character, Integer>> {
    @Override
    public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2){
      return e2.getValue() - e1.getValue();
    }
  }

  public String frequencySort(String s) {
    Map<Character, Integer> countMap = new HashMap<>();
    for(char a: s.toCharArray()){
      if(!countMap.containsKey(a)){
        countMap.put(a, 0);
      }
      countMap.put(a, countMap.get(a) + 1);
    }
    PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>(new EntryComparator());
    pq.addAll(countMap.entrySet());
    StringBuilder builder = new StringBuilder();
    while(!pq.isEmpty()){
      Entry<Character, Integer> entry = pq.poll();
      for(int i = 0; i < entry.getValue(); i++){
        builder.append(entry.getKey());
      }
    }
    ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
    return builder.toString();
  }
}

// Solution 2 - using bucket sort.

class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> countMap = new HashMap<>();
    for(char a: s.toCharArray()){
      if(!countMap.containsKey(a)){
        countMap.put(a, 0);
      }
      countMap.put(a, countMap.get(a) + 1);
    }
    ArrayList<Character> [] bucket = new ArrayList[s.length() + 1];
    for(Entry<Character, Integer> entry: countMap.entrySet()){
      int count = entry.getValue();
      char c = entry.getKey();
      if(bucket[count] == null){
        bucket[count] = new ArrayList<>();
      }
      bucket[count].add(c);
    }
    StringBuilder builder = new StringBuilder();
    for(int i = s.length(); i > 0; i--){
      if(bucket[i] != null){
        for(char a: bucket[i]){
          for(int j = 0; j < i; j++){
            builder.append(a);
          }
        }
      }
    }
    return builder.toString();
  }
}

