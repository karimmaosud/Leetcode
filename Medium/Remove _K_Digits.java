class Solution {
  public String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < num.length(); i++){
      if(stack.isEmpty() && num.charAt(i) != '0'){
        stack.push(num.charAt(i));
        continue;
      }
      while(!stack.isEmpty() && num.charAt(i) < stack.peek() && k > 0){
        k--;
        stack.pop();
      }
      if(stack.isEmpty() && num.charAt(i) == '0'){
        continue;
      }
      stack.push(num.charAt(i));
    }
    while(!stack.isEmpty() && k > 0){
      stack.pop();
      k--;
    }
    StringBuilder builder = new StringBuilder();
    while(!stack.isEmpty()){
      builder.append(stack.pop());
    }
    if(builder.length() == 0){
      builder.append('0');
    }
    return builder.reverse().toString();
  }
}



