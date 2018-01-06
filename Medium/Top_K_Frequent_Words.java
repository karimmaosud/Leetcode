import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Solution {
  class StringComparator implements Comparator<Entry<String, Integer>> {
    @Override
    public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2){
      int diff = e1.getValue() - e2.getValue();
      return diff != 0? diff: e2.getKey().compareTo(e1.getKey());
    }
  }
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordCount = new HashMap<>();
    for(String word: words){
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(new StringComparator());
    for(Entry<String, Integer> entry: wordCount.entrySet()){
      pq.add(entry);
      if(pq.size() > k){
        pq.poll();
      }
    }
    List<String> list = new LinkedList<>();
    while(!pq.isEmpty()){
      list.add(pq.poll().getKey());
    }
    Collections.reverse(list);
    return list;
  }
}
