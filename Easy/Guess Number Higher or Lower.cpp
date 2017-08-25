// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num){
    return num  == 1702766719? 0 : num > 1702766719? -1 : 1;
}

class Solution {
public:
    int guess_with_binary_search(int high){
        int low = 1;
        while(low <= high){
            int mid = (int)(((long long )low+high)/2);
            int guess_res = guess(mid);
            if(guess_res == -1){
                high = mid - 1;
            }else if (guess_res == 1){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    int guessNumber(int n) {
        return guess_with_binary_search(n);
    }
};