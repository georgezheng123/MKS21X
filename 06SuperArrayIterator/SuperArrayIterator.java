import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String> {

  private SuperArray arr;
  private int index;

  public SuperArrayIterator(SuperArray arr) {
        this.data = arr;
        this.index = 0;
  }

  public boolean hasNext(){
        return index < data.size();
  }

  public String next(){
        String next = next.get(index);
        index++;
        return result;
  }

}