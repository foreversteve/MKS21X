
import java.util.*;

public class Sort {

	public static String name(){
	    return "09.Liu.Steven(Haoxuan)";
	}

	//Selection Sort
	public static void selectionSort(int[] data){
		int x,index;
		for (int i = 0; i < data.length; i++) {
			 x = data[i];
			 index = i;
			 for (int k = i; k < data.length; k++) {
				 if (data[k] < x) {
					 x = data[k];
					 index = k;
				 }
			 }
			 data[index] = data[i];
			 data[i] = x;
		}
	}

	//Insertion Sort
	public static void insertionSort(int[] data) {
		int marker = 0;
		int temp;
		for (int i = 0; i < data.length; i++) {
			temp = data[i];

			if (i != 0) {
				for (int k = marker; k > 0 ; k--) {
					if (temp < data[k-1]) {
						data[k] = data[k-1];
						data[k-1] = temp;
					}
					else {
						break;
					}
				}
				marker++;
			}
			else {
				if (temp > data [1]) {
					data[0] = data[i];
					data[i] = temp;
				}
				marker++;
			}
		}
	}

	public static void main(String args[]) {
		//3,2,10,-134,3190,134,1,-3,1203
		int[] testcase = {3,2,10,-134,3190,134,1,-3,1203};
		Sort.selectionSort(testcase);
		System.out.println(Arrays.toString(testcase));
	}
}
