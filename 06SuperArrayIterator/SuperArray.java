import java.util.*;

public class SuperArray implements Iterable<String>{ 

    private String[] data;
    private int size;

    public Iterator<String> iterator(){
    	SuperArrayIterator ans = new SuperArrayIterator(this);
    	return ans;
  	}

    
    public SuperArray(){
	data = new String[10]; 
	size = 0;
    }

    public SuperArray(int len){
	data = new String[len]; 
	size = len;
    }

    public void clear(){
	size = 0;
    }
    
    public int size(){
	return this.size;
    }

    public boolean isEmpty(){
	for (int i=0; i<size; i++){
	    if (data[i] != null) return false;
	}
	return true;
    }

    public boolean add(String element){
	String[] updated = new String[size + 1];
	for (int i=0; i<size; i++){
	    updated[i] = data[i];
	}
	updated[size] = element;
	this.data = updated;
	size++;
	return true;
    }

    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String set(int index, String element){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String[] updated = new String[size];
	String toReturn = get(index);
	for (int i=0; i<size; i++){
	    if (i != index) {
		updated[i] = data[i];
	    }
	    else {
		updated[i] = element;
	    }
	}
	data = updated;
	return toReturn;
    }

    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String ans = "[";
	for (int i=0; i<size-1; i++){
	    ans += data[i] + ",";
	}
	return ans + data[size-1] + "]";
    }

    public boolean contains(String element){
	for (int i=0; i<size; i++){
	    if (data[i] != null && data[i].equals(element)){
		return true;
	    }
	}
	return false;
    }

    public void resize(){
	int bigly = size*2+2;
	String[] updated = new String[bigly];
	for (int i=0; i<size; i++){
	    updated[i] = data[i];
	}
	size = bigly;
	data = updated;
    }
    
    public void add(int index, String element){
	if (index>size() || index<0){
      throw new IndexOutOfBoundsException();
}
	else{
	String[] updated = new String[size+1];
	for (int i=0; i<index; i++){
	    updated[i] = data[i];
	}
	for (int i=index; i<size; i++){
	    updated[i+1] = data[i];
	}
	updated[index] = element;
	data = updated;
	size += 1;}
    }

    public int indexOf(String element){
	if (!contains(element)) {
	    return -1;
	}
	for (int i=0; i<size; i++){
	    if (data[i] != null && data[i].equals(element)){
		return i;
	    }
	}
	return size-1;
    }

     public int lastIndexOf(String element){
	if (!contains(element)) {
	    return -1;
	}
	for (int i=size-1; i>=0; i--){
	    if (data[i] != null && data[i].equals(element)){
		return i;
	    }
	}
	return 0;
    }

    public String remove(int index){
	if (index < 0 || index >= size()){
	    return null;
	}
	String toReturn = data[index];
	for (int i = index; i< size-1; i++){
	    data[i] = data[i+1];
	}
	String[] updated = new String[size-1];
	for (int i=0; i<size-1; i++){
	    updated[i] = data[i];
	}
	data = updated;
	size -= 1;
	return toReturn;
	
	
    }

    public Boolean remove(String target){
	int index = indexOf(target);
	if (index == -1) {
	    return false;
	}
	this.remove(index);
	return true;
    }


}	

