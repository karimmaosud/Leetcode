class Solution {

  private class MyObject {

    int x, h, delta;
    boolean start;

    MyObject(int x, int h, int delta, boolean start) {
      this.x = x;
      this.h = h;
      this.delta = delta;
      this.start = start;
    }
  }

  private class ArrayComparator implements Comparator<MyObject> {

    @Override
    public int compare(MyObject o1, MyObject o2) {
      int diff = o1.x - o2.x;
      if (diff != 0){
        return diff;
      }
      if(o1.start && o2.start){
        return o2.h - o1.h;
      }
      return o1.h - o2.h;
    }
  }

  private class PQComparator implements Comparator<MyObject> {

    @Override
    public int compare(MyObject o1, MyObject o2) {
      return o2.h - o1.h;
    }
  }

  public List<int[]> getSkyline(int[][] buildings) {

    if (buildings.length == 0) {
      return new LinkedList<>();
    }

    LinkedList<int[]> list = new LinkedList<>();
    ArrayList<MyObject> array = new ArrayList<>();

    for (int i = 0; i < buildings.length; i++) {
      int l = buildings[i][0];
      int r = buildings[i][1];
      int h = buildings[i][2];
      array.add(new MyObject(l, h, r - l, true));
      array.add(new MyObject(r, h, l - r, false));
    }

    Collections.sort(array, new ArrayComparator());
    PriorityQueue<MyObject> pq = new PriorityQueue<>(new PQComparator());

    for (int i = 0; i < array.size(); i++) {
      MyObject current = array.get(i);
      while (!pq.isEmpty() && pq.peek().x + pq.peek().delta <= current.x) {
        pq.poll();
      }
      if (current.start) {
        if (pq.isEmpty() || pq.peek().h < current.h) {
          int[] ar = {current.x, current.h};
          addToList(list, ar);
        }
        pq.add(current);
      } else {
        if (pq.isEmpty() || pq.peek().h < current.h) {
          int[] ar = {current.x, pq.isEmpty() ? 0 : pq.peek().h};
          addToList(list, ar);
        }
      }
    }
    return list;
  }
  private void addToList(LinkedList<int[]> list, int[] ar){

    // same x
    if(!list.isEmpty() && list.get(list.size() - 1)[0] == ar[0]){
      list.get(list.size() - 1)[1] = Math.max(list.get(list.size() -1)[1], ar[1]);
      if(list.size() >= 2 && list.get(list.size() -2 )[1] == list.get(list.size() - 1)[1]){
        list.removeLast();
      }
    }else if(list.isEmpty() || list.get(list.size() - 1)[1] != ar[1]){
      list.add(ar);
    }

  }
}