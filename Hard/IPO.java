import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  class Pair{
    int capital, profit;
    Pair(int capital, int profit){
      this.capital = capital;
      this.profit = profit;
    }
  }
  class ArrayComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2){
      return p1.capital - p2.capital;
    }
  }
  class PQComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2){
      return p2.profit - p1.profit;
    }
  }
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    ArrayList<Pair> array = new ArrayList<>();
    for(int i = 0; i < Capital.length; i++){
      array.add(new Pair(Capital[i], Profits[i]));
    }
    Collections.sort(array, new ArrayComparator());
    PriorityQueue<Pair> pq = new PriorityQueue<>(new PQComparator());
    int idx = 0;
    int res = W;
    while(k > 0 && idx < array.size()){
      while(idx < array.size() && array.get(idx).capital <= res){
        pq.add(array.get(idx));
        idx++;
      }
      if(pq.size() == 0){
        break;
      }
      res += pq.poll().profit;
      k--;
    }
    while(k > 0 && !pq.isEmpty()){
      k--;
      res += pq.poll().profit;
    }
    return res;
  }
}

