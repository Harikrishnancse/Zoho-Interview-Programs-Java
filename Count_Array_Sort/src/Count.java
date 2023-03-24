import java.util.*;
public class Count {
	
	private int[] sort(int[] arr,int n) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[i]<arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	private void count_val(int[] arr, int n) {
		int count_arr[][] = new int[n][2];
		int last=0;
		for (int i=0;i<n;i++){
			if(arr[i] == count_arr[last][0]){
				count_arr[last][1] += 1;
			}
			else{
				last+=1;
				count_arr[last][0] = arr[i];
				count_arr[last][1] += 1;
			}
		}
		// function call to print the count matrix
		print(count_arr,last);
		// function calling to sorting based on frequencies
		sort(count_arr,last);
	}

	private void print(int[][] count_arr, int last) {
		System.out.println("------------VALUES and COUNTS----------------");
		for (int i=1;i<=last;i++){
			for(int j=0;j<2;j++){
				System.out.print(count_arr[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}

	private void sort(int[][] count_arr, int last) {
		int temp;
		for(int i=1;i<=last;i++){
			for(int j=i+1;j<=last;j++){
				if(count_arr[i][1] < count_arr[j][1]){
					temp = count_arr[i][0];
					count_arr[i][0]= count_arr[j][0];
					count_arr[j][0]= temp;
					
					temp = count_arr[i][1];
					count_arr[i][1]= count_arr[j][1];
					count_arr[j][1]= temp;
				}
			}
		}
		// function call to print the count matrix
		print(count_arr,last);
		System.out.println("The sorted array based on occurences : ");
		for(int i=1;i<=last;i++){
			for(int j=0;j<count_arr[i][1];j++){
				System.out.print(String.valueOf(count_arr[i][0]) + ' ');
			}
		}
	}

	public static void main(String[] args) {
		Count c = new Count();
		Scanner sc = new Scanner(System.in);
		int arr[],n;
		System.out.print("Enter the number of elements : ");
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		arr = c.sort(arr,n);
		c.count_val(arr,n);
	}

}
