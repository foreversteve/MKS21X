public class Book{
    private String Author,Title,ISBN;
    public Book(){
    }
    public Book(String author, String title, String ISBN){
	this.Author = author;
	this.Title = title;
	this.ISBN = ISBN;
    }
    public String getAuthor(){
	return Author;
    }
    public String getTitle(){
	return Title;
    }
    public String getISBN(){
	return ISBN;
    }
    public String toString(){
	String ans = "";
	ans += Author + "," + Title + "," + ISBN;
	return ans;
    }
    public static void main(String[] args){
	Book a = new Book("Steven", "How To Java", "1092");
	System.out.println(a);
    }
}
