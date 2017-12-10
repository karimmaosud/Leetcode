class Solution {
public:
  vector<int> dailyTemperatures(vector<int>&temperatures) {
    vector<int> ret (temperatures.size(), 0);
    if (temperatures.size() == 0) {
      return ret;
    }
    stack<int> stack;
    stack.push(0);
    for (int i = 1; i < temperatures.size(); i++) {
      while (!stack.empty() && temperatures[i] > temperatures[stack.top()]) {
        ret[stack.top()] = i - stack.top();
        stack.pop();
      }
      stack.push(i);
    }
    return ret;
  }
};