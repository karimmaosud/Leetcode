class MyQueue {

  Stack<Integer> pushStack;
  Stack<Integer> popStack;
  /** Initialize your data structure here. */
  public MyQueue() {
    pushStack = new Stack<>();
    popStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    pushStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    int peek = peek();
    popStack.pop();
    return peek;
  }

  /** Get the front element. */
  public int peek() {
    if(popStack.isEmpty()){
      moveElements(pushStack, popStack);
    }
    return popStack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return popStack.isEmpty() && pushStack.isEmpty();
  }

  private void moveElements(Stack<Integer> x, Stack<Integer> y){
    while(!x.isEmpty()){
      y.push(x.pop());
    }
  }
}