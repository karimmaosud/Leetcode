class Solution {
  public NestedInteger deserialize(String s) {
    NestedInteger dummy = new NestedInteger();
    Stack<NestedInteger> stack = new Stack<>();
    char [] sChars = s.toCharArray();
    int index = 0;
    while(index < sChars.length){
      if(Character.isDigit(sChars[index]) || sChars[index] == '-'){
        StringBuilder builder = new StringBuilder();
        builder.append(sChars[index]);
        int runner = index+1;
        while(runner < sChars.length && Character.isDigit(sChars[runner])){
          builder.append(sChars[runner++]);
        }
        index = runner;
        NestedInteger nestedInteger = new NestedInteger(Integer.parseInt(builder.toString()));
        stack.push(nestedInteger);
        continue;
      }
      if(sChars[index] == '['){
        stack.push(dummy);
      }else if(sChars[index] == ']'){
        LinkedList<NestedInteger> list = new LinkedList<>();
        while(stack.peek() != dummy){
          list.addFirst(stack.pop());
        }
        stack.pop();
        NestedInteger nestedInteger = new NestedInteger();
        for(int i = 0; i < list.size(); i++){
          nestedInteger.add(list.get(i));
        }
        stack.push(nestedInteger);
      }
      index++;
    }
    return stack.pop();
  }
}