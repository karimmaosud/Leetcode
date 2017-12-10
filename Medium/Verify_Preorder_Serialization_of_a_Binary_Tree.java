class Solution {
  public boolean isValidSerialization(String preorder) {

    Stack<String> stack = new Stack<>();
    String [] strs = preorder.split(",");
    int index = 0;
    while(index < strs.length){
      if(strs[index].equals("#")){
        if(stack.isEmpty()){
          break;
        }
        stack.pop();
      }else{
        stack.push(strs[index]);
      }
      index++;
    }
    return index == strs.length - 1;
  }
}