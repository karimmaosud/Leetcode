class Solution {
public:
    int calPoints(vector<string>& ops) {
        stack<int> scores;
        int sum = 0;
        for(int i = 0; i < ops.size(); i++){
            string op = ops[i];
            if(op == "C"){
                sum -= scores.top();
                scores.pop();
                continue;
            }
            int round_score;
            if(op == "+"){
                int num2 = scores.top();
                scores.pop();
                int num1 = scores.top();
                scores.pop();
                round_score = num1 + num2;
                scores.push(num1);
                scores.push(num2);
            }else if(op == "D"){
                round_score = scores.top() * 2;
            }else{
                round_score = atoi(op.c_str());
            }
            scores.push(round_score);
            sum += round_score;
        }
        return sum;
    }
};