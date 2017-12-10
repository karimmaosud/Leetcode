public class NestedIterator implements Iterator<Integer> {

  private void flatList(List<NestedInteger> nestedList, ArrayList<Integer> ret){
    for(NestedInteger nestedInteger: nestedList){
      if(nestedInteger.isInteger()){
        ret.add(nestedInteger.getInteger());
      }else{
        flatList(nestedInteger.getList(), ret);
      }
    }
  }
    
  ArrayList<Integer> elements;
  int start = 0;
  public NestedIterator(List<NestedInteger> nestedList) {
    elements = new ArrayList<>();
    flatList(nestedList, elements);
  }

  @Override
  public Integer next() {
    return elements.get(start++);
  }
  
  @Override
  public boolean hasNext() {
    return start != elements.size();
  }
}