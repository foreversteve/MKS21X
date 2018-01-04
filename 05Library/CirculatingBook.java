public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
    		super(author, title, ISBN, callNumber);
    		currentHolder = null;
    		dueDate = null;
    }

	  public String getCurrentHolder(){
		    return currentHolder;
	  }

    public String getDueDate(){
    		return dueDate;
    }

    public void checkout(String patron, String due){
    		currentHolder = patron;
    		dueDate = due;
    }

    public void returned(){
    		currentHolder = null;
    		dueDate = null;
    }

    public String circulationStatus(){
    		if (currentHolder != null){
    			return currentHolder + ": " + dueDate;
    		}

    		return "book available on shelves";
    }

    public String toString(){
    		if (currentHolder != null){
    			return super.toString() + " " + currentHolder + ": " + dueDate;
    		}

    		return super.toString();
    }
}
