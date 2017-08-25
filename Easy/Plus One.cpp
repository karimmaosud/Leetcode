class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = (int) digits.size();
        int carry = 1;
        for(int i = n-1; i >= 0; i--){
            digits[i]+=carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if(carry != 0){
            vector<int> ret;
            ret.push_back(carry);
            for(int i = 0; i < digits.size(); i++){
                ret.push_back(digits[i]);
            }
            return ret;
        }
        return digits;
    }
};