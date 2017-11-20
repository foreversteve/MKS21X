public class SuperArray{
    private String[] data;
    private int size;
    private int length;
    
    public SuperArray() {
    		this.size = 0;
    		this.length = 10;
    		data = new String[10];
    }
    public SuperArray(int length){
    		this.length = length;
    		data = new String[length];
    		this.size = 0;
    }
   
    public SuperArray(String[] input){
		this.size = input.length;
		data = input;
		this.length = size;
    }
    
    public void changeData(String[] elements) {
    		data = elements;
    		this.size = elements.length;
    }
    public void clear(){
    		for (int i = 0; i < size; i++){
	    data[i] = null;
    		}
    		size = 0;
    }
    public int getLength() {
    		return length;
    }
    public int getSize() {
    		return size;
    }
    
    public boolean isEmpty() {
    		for (String x:data) {
    			if (x != null) {
    				return false;
    			}
    		}
    		return true;
    }
    
    public String get(int index) {
    		return data[index];
    }
    
    public void set(int index, String element) {
    		data[index] = element;
    }
    
    public String toString(){
    		String ans = "[";
    		for (int i = 0; i < data.length; i++){
    			if (i == data.length-1) {
    				ans+= data[i];
    			}
    			else {
    				ans+=data[i]+", ";
    			}
    		}
    		return ans + "]";
    }
    
    public boolean contains(String element) {
    		for (String x:data) {
    			if (x.equals(element)) {
    				return true;
    			}
    		}
    		return false;
    }
    
    public int indexOf(String element) {
    		for (int i = 0; i<data.length; i++) {
    			if (data[i].equals(element)) {
    				return i;
    			}
    		}
    		return -1;
    }
    
    public int lastIndexOf(String element) {
    		for (int i = data.length-1; i>0; i--) {
			if (data[i].equals(element)) {
				return i;
			}
		}
		return -1;
    }
    
    public boolean remove(String element){
    		int index = indexOf(element);
    		if (index == -1) return false;
    		for (int i = index; i < size-1; i++){
			data[i]=data[i+1];
    		}
    		set(data.length-1,null);
    		size--;
    		resize(data.length-1);
		return true;
    }
    
    public String remove(int index) {
    		if (data.length < index) {
    			return "Dumb Ass User Alert";
    		}
    		String removed = data[index];
    		for (int i = index; i < size-1; i++){
			data[i]=data[i+1];
    		}
    		set(data.length-1,null);
    		size--;
    		resize(data.length-1);
		return removed;
    }
    public boolean add(String s) {
    		if (size == data.length) {
			resize(data.length + 1);
		}
    		data[size]=s;
    		size++;
    		return true;
    }
    public void add(int index,String s){
    		if (size == data.length) {
    			resize(data.length + 1);
    		}
    		for (int i = data.length-2; i >= index; i--){
    			data[i+1]=data[i];
    		}
    		data[index]=s;
    		size ++;
    	}
    
    public void resize(int a){
    		String[] x = new String[a];
    		if (a >=  size){
    			for (int i = 0; i < size; i++){
    				x[i] = data[i];
    			}
    			data = x;
    			length = a;
    		}
    }
    
    public static void main(String[]args){
    		String[] lol = {"Hello","NiHao","Hola","Annyeonghaseyo","Kon'nichiwa"};
    		SuperArray a = new SuperArray(lol);
    		
    		System.out.println(a.isEmpty());
    		System.out.println(a);
    		
    		// Check Getters
    		a.resize(5);
    		System.out.println(a.getSize());
    		System.out.println(a.getLength());

    		//Check getIndex
    		System.out.println(a.get(2));
    		
    		//Check set method
    		a.set(4, "hello");
    		System.out.println(a);
    		
    		//Undo the previous method for further testing
    		a.set(4,"Kon'nichiwa");
    		
    		//Check add
    		a.add(2,"Bye");
    		System.out.println(a);
    		System.out.println(a.getSize());
    	
    		//Check Resize
    		a.resize(15);
    		System.out.println(a);
    		
    		//Check Clear & isEmpty
    		a.clear();
        System.out.println(a);
        System.out.println(a.isEmpty());
        
        a.resize(10);
        a.changeData(lol); //Helper Function To Change the Data (Back to original in this case)
        
        //Check IndexOf & LastIndexOf
        System.out.println(a.indexOf("Hello"));
        a.add(5,"Hello");
        System.out.println(a.lastIndexOf("Hello"));
        System.out.println(a);
        
        //Check Remove(String)
        a.remove("Hello");
        System.out.println(a);
        
        //Check Remove(Index)
        System.out.println(a.remove(1));
        System.out.println(a);
        
        //Check Contains
        System.out.println(a.contains("hello"));
        System.out.println(a);
    }
	
}
