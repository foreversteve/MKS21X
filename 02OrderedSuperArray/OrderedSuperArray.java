

public class OrderedSuperArray extends SuperArray {
	
    public OrderedSuperArray(int capacity){
    		super(capacity);
    }
    
    public OrderedSuperArray() {
    		super();
    }
    public OrderedSuperArray(String[] input) {
    		super();
    		for(int i = 0; i < input.length; i++) {
    			add(input[i]);
    		}
    }
    public String set(int index, String element) {
    		throw new UnsupportedOperationException();
    }
    
    private int findIndex(String s) {
    		int l = super.getSize();
    		if (l == 0) {
    			return -1;
    		}
    		for (int i = 0; i < l; i++) {
    			if (super.get(i).compareTo(s) >= 0) {
    				return i;
    			}
    		}
    		return l;
    }
    private int findIndexBinary(String s){
    		if (super.getSize() <= 0) {
    			return -1;
    		}
    		int start = 0;
    		int end = super.getSize()-1;
    		int t;
    		while (start != end) {
    			t = (start + end) / 2;
    			if (super.get(t).compareTo(s) <= 0) {
    				start = t + 1;
    			}
    			else {
    				end = t;
    			}
    		}
    		if (super.get(start).compareTo(s) <= 0) {
    			return start+1;
    		}
    		return start;
    }
    
    public int indexOfBinary(String element) {
    		if (super.getSize() <= 0) {
			return -1;
		}
		int start = 0;
		int end = super.getSize()-1;
		int t;
		while (start != end) {
			t = (start + end) / 2;
			if (super.get(t).compareTo(element) == 0) {
				end = t;
			}
			else if (super.get(t).compareTo(element) < 0) {
				start = t + 1;
			}
			else {
				end = t;
			}
		}
		return start;
    }
    public int lastIndexOf(String element) {
    		if (super.getSize() <= 0) {
			return -1;
		}
		int start = 0;
		int end = super.getSize()-1;
		int t;
		while (start != end) {
			t = (start + end) / 2;
			if (super.get(t).compareTo(element) <= 0) {
				start = t + 1;
			}
			else {
				end = t;
			}
			if (get(start).equals(get(end))) {
				return end-1;
			}
		}
		return start;
    }
    
    public String add(int index, String element) {
    		add(element);
    		return "";
    }
    
    public boolean add(String value){
    		int a = findIndexBinary(value);
    		if (a != -1) {
    			super.add(a,value);
    			return true;
    		}
    		else {
    			super.add(value);
    		}
    		return false;
    }



    public static void main(String[] args){
    		OrderedSuperArray lol = new OrderedSuperArray(4);
    		String[] k = {"hi", "bye", "apple","hi","card","hi","hi","zoo"};
    		for (String x:k) {
    			lol.add(x);
    		}
    		System.out.println(lol);
    		System.out.println(lol.indexOfBinary("hi"));
    		System.out.println(lol.lastIndexOf("hi"));
    		lol.clear();
    		String[] n = {"A","a","b","B","c","C","Apple","C","zoo"};
    		for (String x:n) {
    			lol.add(x);
    			System.out.println(lol);
    		}
    		System.out.println(lol.indexOfBinary("C"));
    		System.out.println(lol.lastIndexOf("C"));
    }
}
