import java.util.Scanner;
public class Count_Digit_Pattern {
	public static void main(String[] args) {
		int n,i,j,k,count;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows : ");
		n = sc.nextInt();
		System.out.println("1");
		System.out.println("1 1");
		String row = "11";
		for(i=2;i<n;i++){
			char arr[] = row.toCharArray();
			String res = "";
			j = 0;
			while( j < arr.length -1){
				count = 1;
				k = j+1;
				
				while( k < arr.length && arr[j]==arr[k] ){
					count += 1;
					k+=1;
				}
				res = res + count + arr[j];
				j = k;
			}
			if (arr[arr.length-1] != arr[arr.length-2]){
				res = res + "1" + arr[arr.length-1];
			}
			
			for(int t=0; t< res.length() ; t++){
				System.out.print( res.charAt(t) + " ");
			}
			System.out.println();
			row = res;
		}
	}
}
