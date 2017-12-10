import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    // n could be 1?
    int [] exclusiveTimes = new int[n];
    int previousTime = -1;
    Stack<Integer> functions = new Stack<>();
    for(String log: logs){
      int firstColon = log.indexOf(':');
      int lastColon = log.lastIndexOf(':');
      int functionId = Integer.parseInt(log.substring(0, firstColon));
      int currentTime = Integer.parseInt(log.substring(lastColon + 1));
      if(functions.isEmpty()){
        functions.push(functionId);
        previousTime = currentTime;
      }else{
        int peek = functions.peek();
        String functionState = log.substring(firstColon + 1, lastColon);
        if(functionId == peek && functionState.equals("end")){
          functions.pop();
          exclusiveTimes[peek]+= (currentTime - previousTime + 1);
          previousTime = currentTime + 1;
        }else{
          functions.push(functionId);
          exclusiveTimes[peek]+= (currentTime - previousTime);
          previousTime = currentTime;
        }
      }
    }
    return exclusiveTimes;
  }
}
