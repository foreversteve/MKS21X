

import java.util.*;

public class Sort {

	public static String name(){
	    return "09.Liu.Steven(Haoxuan)";
	}

	//Selection Sort
	public static void selectionSort(int[] data){
		int x,index;
		if (data.length <= 1) {
			return;
		}
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
		if (data.length <= 1) {
			return;
		}
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

	// Bogo Sort
	public static boolean isSorted(int[] ary){
		for (int i = 0; i < ary.length-1; i++){
			if (ary[i]>ary[i+1]){
				return false;
			}
		}
		return true;
	}

	public static void bogoSort(int[] ary){
		if (ary.length <= 1) {
			return;
		}
        while(!isSorted(ary)){
            for(int i = 0 ; i < ary.length; i++){
                int temp = ary[i];
                int newSpot = (int)(Math.random()*ary.length);
                ary[i] = ary[newSpot];
                ary[newSpot] = temp;
            }
        }
    }

	// Bubble Sort

	public static int swaps(int[] ary, int endMarker) {
		int temp;
		int swapCount = 0;
		for (int i = 1; i <= endMarker; i++) {
			if (ary[i] < ary[i-1]) {
				temp = ary[i-1];
				ary[i-1] = ary[i];
				ary[i] = temp;
				swapCount++;
			}
		}
		return swapCount;
	}

	public static void bubbleSort(int[] ary) {
		int endMarker = ary.length-1;
		if (endMarker <= 0) {
			return;
		}
		while (Sort.swaps(ary,endMarker) != 0) {
			endMarker--;
		}
	}

	//Bucket Sort

	public static int findMax(int[] args){
	    int ans = args[0];
	    for (int i = 1; i < args.length; i++){
	      if (args[i] > ans){
	        ans = args[i];
	      }
	    }
	    return ans;
	  }

	public static int[] bucketSort(int[] args) {
	   if (args.length <= 1) {
		   return args;
	   }
	   int counter = 0;
	   int[] ans = new int[args.length];
	   int[] range = new int[Sort.findMax(args)+1];
	   for (int i = 0; i < args.length; i++){
	     range[args[i]]+=1;
	   }
	   for (int k = 0; k < range.length; k ++){
		  if (range[k] != 0) {
			  for (int l = 0; l < range[k]; l++){
				  ans[counter] = k;
				  counter+=1;
			  }
		  }
	   }

	   return ans;
	}

	public static String toString(int[] argg){
		String ans = "";
	    for (int i = 0; i < argg.length; i++){
	      ans+=argg[i] + ", ";
	    }
	    return ans;
	}

	public static void main(String args[]) {
		//selection sort
		int[] testcase = {3,2,10,-134,3190,134,1,-3,1203};
		Sort.selectionSort(testcase);
		System.out.println(Arrays.toString(testcase));

		System.out.println();

		//bogo Sort
		int[] test = {3,2,10,-134,3190,134,1,-3,1203};
		Sort.bogoSort(test);
		System.out.println(Arrays.toString(test));

		System.out.println();

		//Bubble Sort
		int[] quiz = {3,2,10,-134,3190,134,1,-3,1203};
		Sort.bubbleSort(quiz);
		System.out.println(Arrays.toString(quiz));

		//Bucket Sort
		testcase = new int[10];
	    for (int i = 0; i < testcase.length; i++){
	      testcase[i] = (int)(Math.random()*100);
	    }
	    System.out.println(Sort.findMax(testcase));
	    System.out.println(Arrays.toString(testcase));
	    System.out.println(Arrays.toString(Sort.bucketSort(testcase)));

	}
}
