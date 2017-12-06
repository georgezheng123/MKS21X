abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

	private String callNumber;

	public LibraryBook(String author, String ISBN, String title, String callNumber){
		super(author, ISBN, title);
		this.callNumber = callNumber;
    }

    public void callNumber(String callNumber){
	this.callNumber = callNumber;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public int compareTo(LibraryBook other){
		return getCallNumber().compareTo(other.getCallNumber());
    }


    abstract void checkout(String patron, String due);
abstract void returned();
abstract String circulationStatus();

    public String toString(){
	return super.toString() + ", " + callNumber + ", " + circulationStatus();
    }
}
