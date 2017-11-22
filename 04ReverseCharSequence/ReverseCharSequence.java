public class ReverseCharSequence implements CharSequence{
    String data = "";
    String original;
    public ReverseCharSequence(String input){
	this.original = input;
	for (int i = input.length()-1 ;i >=0; i--){
	    data+= input.substring(i,i+1);
	}
    }
    public char charAt(int index){
	return data.charAt(index);
    }
    public int length(){
	return data.length();
    }
    public CharSequence subSequence(int start, int end){
	String l = this.original;
	CharSequence a = new ReverseCharSequence(l);
	data = data.substring(start,end);
	return a;
    }
    public static void main(String[] args){
	CharSequence lol = new ReverseCharSequence("BLAHblah");
	System.out.println(lol.data);
	System.out.println(lol.subSequence(1,3).data);
    
    }
}
    
	
	
