class Solution {
    bool is_vowel(char a){
        return a == 'a' || a == 'i' || a == 'o' || a == 'e'
        || a == 'u' || a == 'A' || a == 'I' || a == 'O' || a == 'E' || a == 'U';
    }
public:
    string reverseVowels(string s) {
        vector<int> vowel_indicies;
        for(int i = 0; i < s.length(); i++){
            if(is_vowel(s[i])){
                vowel_indicies.push_back(i);
            }
        }
        for(int i = 0; i < vowel_indicies.size()/2; i++){
            int l = vowel_indicies[i];
            int r = vowel_indicies[(int) vowel_indicies.size() - i - 1];
            swap(s[l], s[r]);
        }
        return s;
    }
};
