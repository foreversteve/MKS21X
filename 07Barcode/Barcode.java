public class Barcode implements Comparable<Barcode>{
	private String code,zip;
	public static final String key[]= {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

	public Barcode(String zip){
    		if (zip.length() != 5) {
    			throw new IllegalArgumentException();
    		}
    		this.code = toCode(zip);
    		this.zip = zip;
    }

	public String toString(){
		return this.code + " " + "(" + this.zip + ")";
	}


	public static String toCode(String zip) {
		if (zip.length() != 5) {
			throw new IllegalArgumentException();
		}
    		String tempBar = "";
    		int var = 0;
    		int var2 = 0;
    		for (int i = 0; i < zip.length(); i++) {
    			try{
    				var = Integer.parseInt(zip.substring(i, i+1));
    				var2 += var;
        			tempBar += key[var];
    			}
    			catch(IllegalArgumentException e) {
    				throw new IllegalArgumentException();
    			}
    		}
    		return "|" + tempBar + key[var2%10] + "|";
    }

	public static String toZip(String code) {
		String ans = "";
		if (code.length() != 32 || ! (code.substring(0, 1).equals("|")) || !(code.substring(31,32).equals("|"))){
			throw new IllegalArgumentException();
		}
		for (int i = 1; i < code.length()-5; i+= 5) {
			String val = code.substring(i,i+5);
			int index = Barcode.check(Barcode.key,val);
			if (index == -1) {
				throw new IllegalArgumentException();
			}
			ans+= index;
		}
		if (! checkSum(ans)) {
			throw new IllegalArgumentException();
		}
		return ans;

	}

	public static int check(String[] args, String val){
		for (int i = 0; i < args.length; i++) {
			if (val.equals(args[i])){
				return i;
			}
		}
		return -1;
	}

	public static boolean checkSum(String arg) {
		int sum = 0;
		for (int i = 0; i < arg.length()-1; i++) {
			sum+=Integer.parseInt(arg.substring(i,i+1));
		}
		return sum % 10 == Integer.parseInt(arg.substring(5));
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

    		System.out.println(Barcode.toZip("|:::||:::||:::||::||:::||:|:|::|"));
    		System.out.println(Barcode.toCode("11133"));
    }

}
