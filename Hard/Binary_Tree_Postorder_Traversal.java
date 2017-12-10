class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> postOrder = new LinkedList<>();
    if(root == null){
      return postOrder;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode node = stack.pop();
      postOrder.addFirst(node.val);
      if(node.left != null){
        stack.push(node.left);
      }
      if(node.right != null){
        stack.push(node.right);
      }
    }
    return postOrder;
  }
}