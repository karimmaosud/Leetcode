public class BSTIterator {
  Stack<TreeNode> stack;
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
      pushNodes(root, stack);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !this.stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode peek = stack.pop();
    if(peek.right != null){
      pushNodes(peek.right, stack);
    }
    return peek.val;
  }
  private void pushNodes(TreeNode node, Stack<TreeNode> stack){
    while(node != null){
      stack.push(node);
      node = node.left;
    }
  }
}