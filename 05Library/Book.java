public class Book{

    private String author;
    private String ISBN;
    private String title;

    public Book(){
    }

    public Book(String author, String ISBN, String title){
	this.author = author;
	this.ISBN = ISBN;
	this.title = title;
    }

    public String toString(){
	return title + "," +  author + "," +  ISBN;
    }

    
}
