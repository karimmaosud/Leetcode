class Solution {
  public String decodeString(String s) {

    int index = 0;
    char [] sChars = s.toCharArray();
    Stack<String> strs = new Stack<>();
    Stack<Integer> nums = new Stack<>();
    while(index < sChars.length){
      if(Character.isDigit(sChars[index])){
        int k = 0;
        while(Character.isDigit(sChars[index])){
          k = k*10 + (sChars[index++] - '0');
        }
        nums.push(k);
      }else if(sChars[index] == '['){
        strs.push("[");
        index++;
      }else if(sChars[index] == ']'){
        int k = nums.pop();
        strs.push(getRepeatedString(strs, k));
        index++;
      }else{
        String str = getStr(sChars, index);
        strs.push(str);
        index += str.length();
      }
    }
    return combineStringsFromStack(getReverseStack(strs));
  }
  private String getStr(char[] sChars, int index){
    StringBuilder builder = new StringBuilder();
    while(index < sChars.length && Character.isLetter(sChars[index])){
      builder.append(sChars[index++]);
    }
    return builder.toString();
  }
  private String getRepeatedString(Stack<String> strs, int k){
    Stack<String> reverseStack = getReverseStack(strs);
    strs.pop();
    String combined = combineStringsFromStack(reverseStack);
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < k; i++){
      builder.append(combined);
    }
    return builder.toString();
  }
  private Stack<String> getReverseStack(Stack<String> stack){
    Stack<String> reversedStack = new Stack<>();
    while(!stack.isEmpty() && !stack.peek().equals("[")){
      reversedStack.push(stack.pop());
    }
    return reversedStack;
  }
  private String combineStringsFromStack(Stack<String> strs){
    StringBuilder builder = new StringBuilder();
    while(!strs.isEmpty()){
      builder.append(strs.pop());
    }
    return builder.toString();
  }
}