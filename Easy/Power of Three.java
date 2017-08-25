class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        double x = Math.log10((double) n) / Math.log10(3.0);
        return (int) Math.pow(3, (int) x) == n;
    }
}