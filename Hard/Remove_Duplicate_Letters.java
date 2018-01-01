class Solution {
  public String removeDuplicateLetters(String s) {
    char [] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    int [] count = new int [26];
    boolean [] vis = new boolean[26];
    initCount(chars, count);
    for(int i = 0; i < chars.length; i++){
      if(vis[chars[i] - 'a']){
        continue;
      }
      while(!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && chars[i] < stack.peek()){
        vis[stack.pop() - 'a'] = false;
      }
      vis[chars[i] - 'a'] = true;
      stack.push(chars[i]);
      count[chars[i] - 'a']--;
    }
    StringBuilder builder = new StringBuilder();
    while(!stack.isEmpty()){
      builder.append(stack.pop());
    }
    return builder.reverse().toString();
  }
  private void initCount(char [] chars, int [] count){
    for(int i = 0; i < chars.length; i++){
      count[chars[i] - 'a']++;
    }
  }

  public static void main(String [] args){
    Solution sol = new Solution();
    System.out.println(sol.removeDuplicateLetters("cbacdcbc"));
  }
}