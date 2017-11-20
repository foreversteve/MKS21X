public class OrderedSuperArray extends SuperArray {
    public OrderedSuperArray(int size){
	super(size);
    }
    public void add(int index, String value){
	add(value);
    }
    public boolean add(String value){
	for (int i = 0; i <= super.getSize(); i++){
	    if (value.compareTo(super.get(i)) < 0){
		super.addString(i,value);
		super.increaseSize();
		return true;
	    }
	    if (i == getSize()){
	        super.set(i,value);
	    }
	}
	return false;
    }
    public indexOf(String element){
	int start = 0;
	int end = getSize
	    int value;
	    while (start != end){
		value = (start + end)/2;
		if (get(value).compareTo(element)<0){
		    end = value;
		}
		else{
		    start = value;
		}
		
    public static void main(String[] args){
	SuperArray lol = new OrderedSuperArray(4);
	String[] k = {"hi", "hola", "goodbye", "zaijian"};
	for (String x : k){
	    lol.add(x);
	}
	System.out.println(lol);
    }
}
