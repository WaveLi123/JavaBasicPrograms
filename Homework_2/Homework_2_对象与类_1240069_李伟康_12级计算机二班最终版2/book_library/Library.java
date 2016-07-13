package book_library;

public class Library { 
	//data members
	String address;
	Book [] books = new Book[1230];
	int number_of_book;
	
	//methods
	Library (String in_address){
		this.address = in_address;
	}
	
	void addBook(Book book){
		this.books[this.number_of_book] = new Book(book.getTitle());
		this.number_of_book ++;
	}
	
	static void printOpeningHours(){
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	void printAddress(){
		System.out.println(this.address);
	}
	
	void borrowBook(String book_name){
		int count = 0;
		//Is there the book in our library
		for(count = 0; count < this.number_of_book ; count ++){
			if (this.books[count].title.equals(book_name)){
				//there exists the book in our library.Is the book borrowed?
				if(this.books[count].borrowed){
					System.out.println("Sorry, this book is already borrowed.");
				}
				else{
					this.books[count].borrowed();								//tag the book has been rented
					System.out.println("You successfully borrowed "+this.books[count].title);
				}
				break;
			}
		}
		if(count == this.number_of_book){
			System.out.println("Sorry, this book is not in our catalog.");
		}			
	}
	
	void printAvailableBooks(){
		if(this.number_of_book == 0){
			System.out.println("No book in catalog");
		}
		else{
			for(int count = 0; count < this.number_of_book ; count ++){
				if(!this.books[count].borrowed){
					System.out.println(this.books[count].title);
				}				
			}
		}
	}
	
	void returnBook(String book_name){
		int count = 0;
		//Is there the book in our library
		for(count = 0; count < this.number_of_book ; count ++){
			if (this.books[count].title.equals(book_name)){
				//there exists the book in our library.Is the book borrowed?
				if(this.books[count].borrowed){
					this.books[count].returned();											//tag the book not borrowed
					System.out.println("You successfully returned "+this.books[count].title);
				}
				break;
			}
		}
		if(count == this.number_of_book){
			System.out.println("Sorry, this book is not in our catalog.");
		}
	}
	
	
//	public static void main(String[] args){ 
//		// Create two libraries 
//		Library firstLibrary = new Library("10 Main St."); 
//		Library secondLibrary = new Library("228 Liberty St.");
//		
//		// Add four books to the first library 
//		firstLibrary.addBook(new Book("The Da Vinci Code"));
//		firstLibrary.addBook(new Book("Le Petit Prince"));
//		firstLibrary.addBook(new Book("A Tale of Two Cities"));
//		firstLibrary.addBook(new Book("The Lord of the Rings"));
//	
//		// Print opening hours and the addresses 
//		System.out.println("Library hours:");
//		printOpeningHours();
//		System.out.println();
//		System.out.println("Library addresses:");
//		firstLibrary.printAddress();
//		secondLibrary.printAddress();
//		System.out.println();
//	
//		// Try to borrow The Lords of the Rings from both libraries 
//		System.out.println("Borrowing The Lord of the Rings:");
//		firstLibrary.borrowBook("The Lord of the Rings");
//		firstLibrary.borrowBook("The Lord of the Rings");
//		secondLibrary.borrowBook("The Lord of the Rings");
//		System.out.println();
//	
//		// Print the titles of all available books from both libraries 
//		System.out.println("Books available in the first library:");
//		firstLibrary.printAvailableBooks();
//		System.out.println();
//		System.out.println("Books available in the second library:");
//		secondLibrary.printAvailableBooks();
//		System.out.println();
//		// Return The Lords of the Rings to the first library 
//		System.out.println("Returning The Lord of the Rings:"); 
//		firstLibrary.returnBook("The Lord of the Rings"); 
//		System.out.println(); 
//		// Print the titles of available from the first library 
//		System.out.println("Books available in the first library:"); firstLibrary.printAvailableBooks();
//	}
	
}