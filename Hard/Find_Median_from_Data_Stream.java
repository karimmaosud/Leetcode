class MedianFinder {
  /** initialize your data structure here. */
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;
  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    if(!maxHeap.isEmpty() && num < maxHeap.peek()){
      maxHeap.add(num);
    }else{
      minHeap.add(num);
    }
    balanceHeaps();
  }

  public double findMedian() {
    if(maxHeap.size() > minHeap.size()){
      return 1.0 * maxHeap.peek();
    }else{
      return (1.0 * (maxHeap.peek() + minHeap.peek())) / 2.0;
    }
  }

  private void balanceHeaps(){
    if(maxHeap.size() - minHeap.size() > 1){
      minHeap.add(maxHeap.poll());
    }else if(minHeap.size() - maxHeap.size() > 0){
      maxHeap.add(minHeap.poll());
    }
  }
}