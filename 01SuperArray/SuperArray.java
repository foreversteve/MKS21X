public class SuperArray{
    private String[] data;
    private int size;
    private int DEFAULT_SIZE = 10;
    public SuperArray(int size){
	this.size = size;
	data = new String[DEFAULT_SIZE];
    }
    public void clear(){
	for (int i = 0; i < size; i++){
	    data[i] = "0";
	}
    }
    public String toString(){
	String ans = "";
	for (int i = 0; i < data.length; i++){
	    ans+=data[i]+" ";
	}
	return ans;
    }
    public void addString(int index,String s){
	for (int i = index+1; i < size; i++){
	    data[i]=data[i-1];
	}
	data[index]=s;
	this.size ++;
    }
    public void resize(int a){
	String[] x = new String[a];
	if (a >=  data.length){
	    for (int i = 0; i < data.length; i++){
		x[i] = data[i];
	    }
	}
	data = x;
    }
    public static void main(String[]args){
	SuperArray a = new SuperArray(4);
	for (int i = 0; i<4; i++){
	    if (i%2 == 0){
		a.data[i] = "hi";
	    }
	    else{
		a.data[i]="hello";
	    }
	}
	System.out.println(a);
	a.addString(2,"YEAH");
	System.out.println(a);
        a.clear();
	System.out.println(a);
	a.resize(15);
	System.out.println(a);
	
    }
	
}
