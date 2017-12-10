class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> levelNodes = new LinkedList<>();
    if(root == null){
      return levelNodes;
    }
    queue.add(root);
    boolean levelOrder = true;
    while(!queue.isEmpty()){
      int levelNodesCount = queue.size();
      LinkedList<Integer> list = new LinkedList<>();
      for(int i = 0; i < levelNodesCount; i++){
        TreeNode node = queue.poll();
        if(levelOrder){
          list.addLast(node.val);
        }else{
          list.addFirst(node.val);
        }
        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
      }
      levelNodes.add(list);
      levelOrder = !levelOrder;
    }
    return levelNodes;
  }
}
