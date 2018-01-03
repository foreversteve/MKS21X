public class ReversedCharSequence implements CharSequence{

    String data = "";
    String original;
    public ReversedCharSequence(String input){
	     this.original = input;
	     for (int i = input.length()-1 ;i >=0; i--){
	        data+= input.substring(i,i+1);
	       }
    }
    public String toString(){
      return data;
    }
    public char charAt(int index){
	     return data.charAt(index);
    }
    public int length(){
	     return data.length();
    }
    public CharSequence subSequence(int start, int end){
	     int l = original.length();
	     String temp = data.substring(start,end);
	      CharSequence a = new ReversedCharSequence(original.substring(l-end,l-start));
	       return a;
    }
    public static void main(String[] args){
	     CharSequence lol = new ReversedCharSequence("BLAHblah");
	      System.out.println(lol);
	       System.out.println(lol.subSequence(1,3));
          System.out.println(lol.charAt(3));
    }
}
