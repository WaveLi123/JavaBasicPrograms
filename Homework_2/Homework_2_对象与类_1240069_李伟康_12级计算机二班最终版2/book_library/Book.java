package book_library;

public class Book {
	//data members
	String title;
	boolean borrowed;
	
	
	
	//methods
	// Creates a new Book 
	public Book(String bookTitle){ 
		this.title = bookTitle;
	} 
	
	// Marks the book as rented 
	public void borrowed() {
		this.borrowed = true;
	} 
	
	// Marks the book as not rented 
	public void returned() { 
		this.borrowed = false;
	} 
	
	// Returns true if the book is rented, false otherwise 
	public boolean isBorrowed() {		
		if(this.borrowed == true){
			return true;
		}
		else return false;
	} 
	
	// Returns the title of the book 
	public String getTitle() {		
		return this.title;
	}
/*
	public static void main(String[] args){ 
		// Small test of the Book class 
		Book example = new Book("The Da Vinci Code");
		System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
		example.borrowed();
		System.out.println("Borrowed? (should be true): " + example.isBorrowed());
		example.returned();
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
		}
	*/ 
}

