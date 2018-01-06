import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  class MyObject{
    int row;
    int column;
    int value;
    MyObject(int row, int column, int value){
      this.row = row;
      this.column = column;
      this.value = value;
    }
  }
  class PQComparator implements Comparator<MyObject> {
    @Override
    public int compare(MyObject o1, MyObject o2){
      return o1.value - o2.value;
    }
  }
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<MyObject> pq = new PriorityQueue<>(new PQComparator());
    pq.add(new MyObject(0, 0, matrix[0][0]));
    int count = 0;
    int res = 0;
    while(count < k){
      MyObject myObject = pq.poll();
      int row = myObject.row;
      int column = myObject.column;
      res = myObject.value;
      count++;
      if(row + 1 < n && matrix[row + 1][column] != Integer.MIN_VALUE ){
        pq.add(new MyObject(row + 1, column, matrix[row + 1][column]));
        matrix[row + 1][column] = Integer.MIN_VALUE;
      }
      if(column + 1 < n && matrix[row][column + 1] != Integer.MIN_VALUE){
        pq.add(new MyObject(row, column + 1, matrix[row][column + 1]));
        matrix[row][column + 1] = Integer.MIN_VALUE;
      }

    }
    return res;
  }
}


