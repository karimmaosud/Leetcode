import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  private class PQObject{
    int value, row, column;
    PQObject(int value, int row, int column){
      this.value = value;
      this.row = row;
      this.column = column;
    }
  }

  private class PQComparator implements Comparator<PQObject> {
    @Override
    public int compare(PQObject o1, PQObject o2){
      return o1.value - o2.value;
    }
  }

  public int trapRainWater(int[][] heightMap) {
    int n = heightMap.length;

    if(n == 0){
      return 0;
    }

    int  m = heightMap[0].length;

    PriorityQueue<PQObject> pq = new PriorityQueue<>(new PQComparator());
    boolean [][] vis = new boolean[n][m];

    initPQ(heightMap, pq, n, m, vis);

    int res = 0;
    while(!pq.isEmpty()){
      // a vis node.
      PQObject pqObject = pq.poll();
      vis[pqObject.row][pqObject.column] = false;
      res += dfs(heightMap, pq, pqObject.row, pqObject.column, vis, n , m, pqObject.value);
    }
    return res;
  }

  private void initPQ(int[][] heightMap, PriorityQueue<PQObject> pq, int n, int m, boolean [][] vis){
    // first and rows
    for(int j = 0; j < m; j++){
      pq.add(new PQObject(heightMap[0][j], 0, j));
      pq.add(new PQObject(heightMap[n-1][j], n-1, j));
      vis[0][j] = vis[n-1][j] = true;
    }

    // first and last columns
    for(int i = 1; i < n - 1; i++){
      pq.add(new PQObject(heightMap[i][0], i, 0));
      pq.add(new PQObject(heightMap[i][m-1], i, m-1));
      vis[i][0] = vis[i][m-1] = true;
    }
  }

  private int dfs(int[][] heightMap, PriorityQueue<PQObject> pq, int row, int column, boolean [][] vis, int n, int m, int maxValue){
    if(row < 0 || row == n || column < 0 || column == m || vis[row][column]){
      return 0;
    }
    vis[row][column] = true;
    if(heightMap[row][column] > maxValue){
      pq.add(new PQObject(heightMap[row][column], row, column));
      return 0;
    }
    int [] rowInc = {1, 0, -1, 0};
    int [] colInc = {0, 1, 0, -1};
    int ans = maxValue - heightMap[row][column];
    for(int i = 0; i < 4; i++){
      ans += dfs(heightMap, pq, row + rowInc[i], column + colInc[i], vis, n , m, maxValue);
    }
    return ans;
  }
}

