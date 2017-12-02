package Barcode;

public class Barcode implements Comparable<Barcode>{
	private String code,zip;
	public final String key[]= {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    
	public Barcode(String zip){
    		this.code = "|"+ convertZip(zip) + "|" + " " + "(" + zip + ")";
    		this.zip = zip;
    }
	
	public String toString(){
		return this.code;
	}
	
	private String convertZip(String zip) {
    		String tempBar = "";
    		int var = 0;
    		for (int i = 0; i < zip.length(); i++) {
    			var = Integer.parseInt(zip.substring(i, i+1));
    			tempBar += key[var];
    		}
    		return tempBar;
    }
	
	public int compareTo(Barcode other) {
		return other.getZip().compareTo(this.getZip());
	}
	
	public boolean equals(Barcode other) {
		return this.compareTo(other) == 0;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getZip() {
		return zip;
	}
	
    public static void main(String args[]) {
    		Barcode y = new Barcode("11133");
    		Barcode x = new Barcode("11111");
    		
    		System.out.println(y);
    		System.out.println(y.getZip());
    		System.out.println(y.getCode());
    		
    		System.out.println(x.equals(y));
    		System.out.println(x.compareTo(y));
    		
    		System.out.println("521".compareTo("321"));
    }
    
}
