class CirculatingBook extends LibraryBook{

	private String currentHolder;
	private String dueDate;

	public CirculatingBook(String author, String ISBN, String title, String callNumber){
		super(author, ISBN, title, callNumber);
    }

        public void checkout(String patron, String due){
        	currentHolder = patron;
        	dueDate = due;
        }

public void returned(){
	currentHolder = null;
        	dueDate = null;}
public String circulationStatus(){
	if (dueDate == null) return "book available on shelves";
	return currentHolder + " " + dueDate;
}
    public String toString(){
	return super.toString() + ", "  + circulationStatus();
    }

}