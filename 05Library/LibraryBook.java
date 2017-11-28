
public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String author, String title, int ISBN, String callNumber){
	super(author,title,ISBN);
	this.callNumber = callNumber;
    }
    public String getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(String input){
	callNumber = input;
    }
    public int compareTo(LibraryBook other){
	return callNumber.compareTo(other.callNumber);
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
}
