class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < asteroids.length; i++){
      if(stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0){
        stack.push(asteroids[i]);
      }else if(-asteroids[i] > stack.peek()){
        stack.pop();
        i--;
      }else if(-asteroids[i] == stack.peek()){
        stack.pop();
      }
    }

    return stack.stream().mapToInt(i -> i).toArray();
  }
}