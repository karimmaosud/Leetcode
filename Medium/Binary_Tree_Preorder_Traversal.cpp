class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ret;
        if(root == NULL){
            return ret;
        }
        stack<TreeNode*> stack;
        stack.push(root);
        while(!stack.empty()){
            TreeNode* cur = stack.top();
            stack.pop();
            ret.push_back(cur->val);
            if(cur->right != NULL){
                stack.push(cur->right);
            }
            if(cur->left != NULL){
                stack.push(cur->left);
            }
        }
        return ret;
    }
};