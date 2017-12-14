public class Temperature{
    double F,C;
    public static double CtoF(double t){
    		return t*1.8+32;
    }
    public static double FtoC(double k){
    		return (k-32)/1.8;
    }
    public static void main(String args[]) {
    		System.out.println(Temperature.CtoF(15));
    		System.out.println(Temperature.FtoC(Temperature.CtoF(15)));
    }
}
