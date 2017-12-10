class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> list;
        stack<TreeNode*> stack;
        TreeNode* cur = root;
        while(cur != NULL || !stack.empty()){
            while(cur != NULL){
                stack.push(cur);
                cur = cur->left;
            }
            cur = stack.top();
            stack.pop();
            list.push_back(cur->val);
            cur = cur->right;
        }
        return list;
    }
};