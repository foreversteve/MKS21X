public class Temperature{
    double F,C;
    public static double CtoF(double t){
	return (t+32)*9/5;
    }
    public static double FtoC(double t){
	return 5/9*t-32;
    }
}
