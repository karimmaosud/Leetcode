class Solution {
  private class Tag{
    String tagName;
    boolean isOpen;
    Tag(String tagName, boolean isOpen){
      this.tagName = tagName;
      this.isOpen = isOpen;
    }

    boolean match(Tag otherTag){
      return this.tagName.equals(otherTag.tagName);
    }
  }
  private static class Constants{
    static String cDataOpen = "<![CDATA[";
    static String cDataClose = "]]>";
  }
  public boolean isValid(String code) {
    Stack<Tag> stack = new Stack<>();
    char [] chars = code.toCharArray();
    int index = 0;
    while(index < chars.length){
      if(chars[index] == '<'){
        if(index + 1 < chars.length && chars[index+1] != '!'){
          // has to be a tag
          Tag tag = parseTag(++index, chars);
          if(tag == null){
            // invalid tag
            return false;
          }
          index += (tag.tagName.length() + 1 + (tag.isOpen? 0: 1));
          if(tag.isOpen){
            stack.push(tag);
          }else if(stack.isEmpty() || !stack.peek().match(tag)){
            return false;
          }else{
            stack.pop();
            if(stack.isEmpty() && index < chars.length){
              return false;
            }
          }
        }else if(isCDataOpen(index, chars) && !stack.isEmpty()){
          // parse data
          index += Constants.cDataOpen.length();
          int skippedChars = skipCharsInCData(index, chars);
          if(skippedChars == -1){
            // couldn’t find cDataClose
            return false;
          }
          index += skippedChars;
        }else{
          return false;
        }
      }else if(stack.isEmpty()){
        // stack can’t be empty in case of failure to pase tag and tagContent
        return false;
      }else{
        index++;
      }
    }
    return stack.isEmpty();
  }
  private Tag parseTag(int index, char [] chars){
    if(index == chars.length){
      return null;
    }
    boolean isOpen = true;
    if(chars[index] == '/'){
      index++;
      isOpen = false;
    }
    int len = 0;
    StringBuilder builder = new StringBuilder();
    while(index < chars.length){
      if(chars[index] == '>'){
        break;
      }
      if(!Character.isUpperCase(chars[index])){
        return null;
      }
      builder.append(chars[index]);
      index++;
      len++;
      if(len > 9){
        break;
      }
    }
    if(len < 1 || len > 9){
      return null;
    }
    return new Tag(builder.toString(), isOpen);
  }

  private boolean isCDataOpen(int index, char [] chars){
    StringBuilder builder = new StringBuilder();
    while(index < chars.length && builder.length() < Constants.cDataOpen.length()){
      builder.append(chars[index++]);
    }
    return builder.toString().equals(Constants.cDataOpen);
  }

  private int skipCharsInCData(int index, char [] chars){
    int skippedChars = 0;
    while(index < chars.length && !closingCData(index, chars)){
      index ++;
      skippedChars++;
    }
    if(index != chars.length){
      skippedChars += Constants.cDataClose.length();
      return skippedChars;
    }
    return -1;
  }
  private boolean closingCData(int index, char[] chars){
    return index + 2 < chars.length &&
        chars[index] == ']' && chars[index+1] == ']' && chars[index+2] == '>';
  }
}






