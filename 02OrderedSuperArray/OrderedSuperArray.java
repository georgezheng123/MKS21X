public class OrderedSuperArray extends SuperArray{

  /*constructor initializes an empty List*/
  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(int len){
    super(len);
  }

  public OrderedSuperArray(String [] ary){
    super();
    for (int i=0; i<ary.length; i++){
      add(ary[i]);
    }
  }

public String set(int index, String element){
      throw new UnsupportedOperationException();
  }

  /*call the proper add.*/
  public void add(int index, String value){
    add(value);
  }

  /*Write this method and any
    appropriate helper methods.*/
  public boolean add(String value){
    for (int i=0; i<size(); i++){
      if (value.compareTo(get(i)) < 0) {
        super.add(i, value);
        return true;
      }
    }
    super.add(size(),value);
  
    return true;
  }

  public int indexOf(String element){
    int first = 0, last = size() - 1;
    while (first <= last){
      int middle = first + (last-first)/2;
      if (get(middle).compareTo(element) == 0){
        while (middle > 0 && get(middle-1)==element){
          middle -= 1;
        }
        return middle;
      }
      if (get(middle).compareTo(element) < 0) first = middle + 1;
      else last = middle - 1;
    } 
    return -1;
  }

    public int indexOfBinary(String element){
      return indexOf( element);
}

  public int lastIndexOf(String element){
    int first = 0, last = size() - 1;
    while (first <= last){
      int middle = first + (last-first)/2;
      if (get(middle).compareTo(element) == 0){
        while (middle < size()-1 && get(middle+1)==element){
          middle += 1;
        }
        return middle;
      }
      if (get(middle).compareTo(element) < 0) first = middle + 1;
      else last = middle - 1;
    }
    return -1;
  }

  public int lastIndexOfBinary(String element){
    return lastIndexOf(element);
  }

  public int findIndex(String value){
    for (int i=0; i<size(); i++){
      if (value.compareTo(get(i)) < 0) {
        return i;
      }
    }  
    return size();
  }

    public int findIndexBinary(String element){
      if (!super.contains(element)) return -1;
    int first = 0, last = size() - 1;
    while (first <= last){
      int middle = first + (last-first)/2;
      if (get(middle).compareTo(element) == 0){
        return middle;
      }
      if (get(middle).compareTo(element) < 0) first = middle + 1;
      else last = middle - 1;
    } 
    return first;
  }

}