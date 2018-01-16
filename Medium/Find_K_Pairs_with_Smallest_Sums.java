class Solution {
  private class Pair{
    int sum, i, j;
    Pair(int sum, int i, int j){
      this.sum = sum;
      this.i = i;
      this.j = j;
    }
    @Override
    public boolean equals(Object o){
      if(! ( o instanceof Pair) ){
        return false;
      }
      Pair that = (Pair) o;
      return this.i == that.i && this.j == that.j;
    }
    @Override
    public int hashCode(){
      return this.i * 10000007 + j;
    }
  }
  private class PQComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2){
      return p1.sum - p2.sum;
    }
  }
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if(nums1.length == 0 || nums2.length == 0){
      return new LinkedList<>();
    }

    List<int[]> list = new LinkedList<>();
    int n = nums1.length;
    int m = nums2.length;
    Set<Pair> set = new HashSet<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>(new PQComparator());
    pq.add(new Pair(nums1[0] + nums2[0], 0, 0));

    while(list.size() < Math.min(m*n, k)){
      Pair pair = pq.poll();
      int i = pair.i;
      int j = pair.j;
      int [] indicies = {nums1[i], nums2[j]};
      list.add(indicies);
      if(i + 1 < nums1.length){
        Pair left = new Pair(nums1[i+1] + nums2[j], i+1, j);
        if(!set.contains(left)){
          set.add(left);
          pq.add(left);
        }
      }
      if(j + 1 < nums2.length){
        Pair right = new Pair(nums1[i] + nums2[j+1], i, j+1);
        if(!set.contains(right)){
          set.add(right);
          pq.add(right);
        }
      }
    }
    return list;
  }
}
