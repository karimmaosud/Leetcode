class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    ListNode mergedList = null;
    ListNode res = null;

    for(int i = 0; i < lists.length; i++){
      if (lists[i] != null){
        pq.add(lists[i]);
      }
    }

    while(!pq.isEmpty()){
      ListNode current = pq.poll();
      if(current.next != null){
        pq.add(current.next);
      }
      if(mergedList == null){
        mergedList = current;
        res = mergedList;
      }else{
        mergedList.next = current;
        mergedList = mergedList.next;
      }
    }
    return res;
  }
}
