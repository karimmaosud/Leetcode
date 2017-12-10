class Solution {
public:
    void pre_calculate(vector<int>& nums, map<int,int>& next_greater){
        if(nums.size() == 0){
            return;
        }
        stack<int> decending_nums;
        decending_nums.push(nums[0]);
        for(int i = 1; i < nums.size(); i++){
            while(!decending_nums.empty() && nums[i] > decending_nums.top()){
                int prev = decending_nums.top();
                decending_nums.pop();
                next_greater[prev] = nums[i];
            }
            decending_nums.push(nums[i]);
        }
    }
    vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {
        map<int,int> next_greater;
        pre_calculate(nums, next_greater);
        vector<int> ret;
        for(int i = 0; i < findNums.size(); i++){
            if(!next_greater.count(findNums[i])){
                ret.push_back(-1);
            }else{
                ret.push_back(next_greater[findNums[i]]);
            }
        }
        return ret;
    }
};