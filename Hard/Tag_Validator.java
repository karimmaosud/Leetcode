class Solution {

  public boolean isValid(String code){
    Stack<String> stack = new Stack<>();
    int index = 0;
    while(index < code.length()){
      if(index > 0 && stack.isEmpty()){
        return false;
      }
      if(code.charAt(index) == '<'){
        if(code.startsWith("<![CDATA[", index)){
          int cDataCloseIndex = code.indexOf("]]>", index + 9);
          if(cDataCloseIndex == -1){
            return false;
          }
          index = cDataCloseIndex + 3;
        }else if(code.startsWith("</", index)){
          // close tag
          index += 2;
          int closeTagIndex = code.indexOf(">", index);
          String tagName = getValidTag(index, closeTagIndex - 1, code);
          if(tagName == null || stack.isEmpty() || !stack.pop().equals(tagName)){
            return false;
          }
          index = closeTagIndex + 1;
        }else{
          // open tag
          index++;
          int closeTagIndex = code.indexOf(">", index);
          String tagName = getValidTag(index, closeTagIndex - 1, code);
          if(tagName == null){
            return false;
          }
          stack.push(tagName);
          index = closeTagIndex + 1;
        }
      }else{
        index++;
      }
    }
    return stack.isEmpty();
  }

  private String getValidTag(int startIndex, int endIndex, String code){
    int tagLength = endIndex - startIndex + 1;
    if(tagLength < 1 || tagLength > 9){
      return null;
    }
    String tagName = code.substring(startIndex, endIndex + 1);
    for(char c: tagName.toCharArray()){
      if(!Character.isUpperCase(c)){
        return null;
      }
    }
    return tagName;
  }
}
