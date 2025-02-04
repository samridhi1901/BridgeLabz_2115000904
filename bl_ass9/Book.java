class Book{
	private static String libraryName="library";
	private String title;
	private String author;
	private final String isbn;
	public Book(String title,String author,String isbn){
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}
	public static void displayLibraryName(){
		System.out.println("the name of library is"+libraryName);
	}
	public void displaylibraryinfo(){
		if(this instanceof Book){
		System.out.println("The title name" + title);
		System.out.println("The author name" + author);
		System.out.println("The isbn number" + isbn);
		}
		else{
			System.out.println("The invalid class");
		}
	}
	public static void main(String args[]){
		Book b1=new Book("jungle book","alex","vyz");
		Book b2=new Book("xyz","sam","ooo");
		b1.displaylibraryinfo();
		System.out.println("----------------------");
		b2.displaylibraryinfo();
		System.out.println("----------------------");
		Book.displayLibraryName();
	}
}
	
	