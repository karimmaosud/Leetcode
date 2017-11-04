class Solution {
    void solve(int index, int rem, vector<int>& candidates, vector<int>& cur_nums, vector<vector<int>>& result){
        if(rem == 0){
            result.push_back(cur_nums);
            return;
        }
        if(rem < 0 || index == candidates.size()){
            return;
        }
        cur_nums.push_back(candidates[index]);
        solve(index, rem - candidates[index], candidates, cur_nums, result);
        cur_nums.pop_back();
        solve(index+1, rem, candidates, cur_nums, result);
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> cur_nums;
        solve(0, target, candidates, cur_nums, result);
        return result;
    }
};

