class MyStack {
  private Queue<Integer> pushQueue;
  private Queue<Integer> popQueue;

  /** Initialize your data structure here. */
  public MyStack() {
    pushQueue = new LinkedList<>();
    popQueue = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    if(!pushQueue.isEmpty()){
      popQueue.add(pushQueue.poll());
    }
    pushQueue.add(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    int ret = pushQueue.poll();
    while(popQueue.size() > 1){
      pushQueue.add(popQueue.poll());
    }
    Queue<Integer> temp = pushQueue;
    pushQueue = popQueue;
    popQueue = temp;
    return ret;
  }

  /** Get the top element. */
  public int top() {
    return pushQueue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return pushQueue.isEmpty() && popQueue.isEmpty();
  }
}