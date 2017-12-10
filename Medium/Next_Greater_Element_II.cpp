class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> ret(nums.size(), -1);
        if(nums.size() == 0){
            return ret;
        }
        stack<int> stack;
        stack.push(0);
        int size = (int) nums.size();
        for(int i = 1; i < 2*size; i++){
            while(!stack.empty() && nums[i%size] > nums[stack.top()%size]){
                ret[stack.top()] = nums[i%size];
                stack.pop();
            }
            if(i < size){
                stack.push(i);
            }
        }
        return ret;
    }
};