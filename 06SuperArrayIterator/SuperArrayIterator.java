import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String> {

  private SuperArray arr;
  private int index;

  public SuperArrayIterator(SuperArray arr) {
        this.arr = arr;
        this.index = 0;
  }

  public boolean hasNext(){
        return index < arr.size();
  }

  public String next(){
        return arr.get(index++);
  }

}