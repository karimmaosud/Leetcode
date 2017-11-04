class Solution {
    private boolean validMove(int i, int j, int moveIndex, int [] rowInc, int [] columnInc, int [][] matrix, int n){
        int i_ = i + rowInc[moveIndex];
        int j_ = j + columnInc[moveIndex];
        return i_ >= 0 &&
            i_ < n &&
            j_ >= 0 &&
            j_  < n &&
            matrix[i_][j_] == 0;
    }
    public int[][] generateMatrix(int n) {
        int matrix [][] = new int [n][n];
        int rowInc [] = {0, 1, 0, -1};
        int columnInc [] = {1, 0, -1, 0};
        int moveIndex = 0;
        int i =0, j =0;
        int currentNumber = 0;
        while(i < n && j < n && matrix[i][j] == 0){
            matrix[i][j] = ++currentNumber;
            if(!validMove(i, j, moveIndex, rowInc, columnInc, matrix, n)){
                moveIndex = (moveIndex + 1)%4;
            }
            i += rowInc[moveIndex];
            j += columnInc[moveIndex];
        }
        return matrix;
    }
}

