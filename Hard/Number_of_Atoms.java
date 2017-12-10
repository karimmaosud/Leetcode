class Solution {
  class MyObject{
    String element;
    int atomsCount;
    public MyObject(String element, int atomsCount){
      this.element = element;
      this.atomsCount = atomsCount;
    }
  }

  class IntegerWrapper{
    int value;
  }

  private boolean isLowerCase(char a){
    return a >= 'a' && a <= 'z';
  }

  private boolean isNumber(char a){
    return a >= '0' && a <= '9';
  }

  private String getElement(int index, char[] formulaChars){
    StringBuilder builder = new StringBuilder();
    builder.append(formulaChars[index++]);
    while(index < formulaChars.length && isLowerCase(formulaChars[index])){
      builder.append(formulaChars[index++]);
    }
    return builder.toString();
  }

  private int getAtomsCount(int index, char[] formulaChars, IntegerWrapper wrapper){
    int length = 0;
    int count = 0;
    while(index < formulaChars.length && isNumber(formulaChars[index])){
      count = count*10 + (formulaChars[index] - '0');
      index++;
      length++;
    }
    wrapper.value = length;
    if(count == 0){
      // means that you have only one atom
      return 1;
    }
    return count;
  }

  public String countOfAtoms(String formula) {
    char [] formulaChars = formula.toCharArray();
    MyObject dummyObject = new MyObject("", 0);
    Stack<MyObject> stack = new Stack<>();
    int index = 0;
    while(index < formula.length()){
      if(formula.charAt(index) == '('){
        stack.push(dummyObject);
        index++;
      }else if(formula.charAt(index) == ')'){
        index++;
        IntegerWrapper length = new IntegerWrapper();
        int mul = getAtomsCount(index, formulaChars, length);
        if(mul != 1){
          // do stack poping
          Stack<MyObject> tempStack = new Stack<>();
          while(stack.peek() != dummyObject){
            MyObject peek = stack.pop();
            peek.atomsCount *= mul;
            tempStack.push(peek);
          }
          stack.pop();
          while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
          }
        }
        index += length.value;
      }else{
        String element = getElement(index, formulaChars);
        index += element.length();
        IntegerWrapper length = new IntegerWrapper();
        int atomsCount = getAtomsCount(index, formulaChars, length);
        index += length.value;
        stack.push(new MyObject(element, atomsCount));
      }
    }
    TreeMap<String, Integer> elementAtoms = new TreeMap<>();
    while(!stack.isEmpty()){
      MyObject peek = stack.pop();
      if(!elementAtoms.containsKey(peek.element)){
        elementAtoms.put(peek.element, 0);
      }
      elementAtoms.put(peek.element, elementAtoms.get(peek.element) + peek.atomsCount);
    }
    Set<String> orderedElements = elementAtoms.keySet();
    StringBuilder output = new StringBuilder();
    for(String element: orderedElements){
      output.append(element);
      if(elementAtoms.get(element) > 1){
        output.append(elementAtoms.get(element));
      }
    }
    return output.toString();
  }
}