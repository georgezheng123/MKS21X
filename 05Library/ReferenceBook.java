class ReferenceBook extends LibraryBook{

	private String collection;

	public ReferenceBook(String author, String ISBN, String title, String callNumber, String collection){
		super(author, ISBN, title, callNumber);
		this.collection = collection;
    }

        public void checkout(String patron, String due){
        	System.out.println("cannot check out a reference book");
        }

public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
}
public String circulationStatus(){
	return "non-circulating reference book";
}

    public String toString(){
	return super.toString() + ", " + getCallNumber() + ", " + circulationStatus();
    }

}