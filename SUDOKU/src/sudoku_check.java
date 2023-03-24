import java.util.Scanner;
public class sudoku_check {
	
	private static boolean check(int[] tr) {
		int visited[] = {0,0,0,0,0,0,0,0,0};
		int val;
		for (int ind =0 ; ind<9 ; ind++){
			val = tr[ind];
			if ( visited[ val-1] != 0 ){
				return false;
			}
			else{
				visited[ val-1]++;
			}
		}
		return true;
	}

	private static boolean row_check(int[][] arr) {
        boolean row_c = true;
		int tr[]=new int[9];
		for (int i=0;i<9;i++){
			for (int j=0;j<9;j++){
				tr[j] = arr[i][j]; 
			}
			row_c = check(tr);
			if (row_c == false){
				return false;
			}
		}
		return true;
	}

	private static boolean col_check(int[][] arr) {
		boolean col_c = true;
		int tc[]=new int[9];
		for (int i=0;i<9;i++){
			for (int j=0;j<9;j++){
				tc[j] = arr[j][i]; 
			}
			col_c = check(tc);
			if (col_c == false){
				return false;
			}
		}
		return true;
	}
    
	private static boolean sub_check(int[][] arr) {
		boolean sub_c = true ;
		int temp[];
		int i1,j1,i2,j2,i,j,k;
		i1=0;
		i2=2;
		while (i2<9){
			j1=0 ;
			j2=2; 
			while (j2<9){
				temp= new int[9];
				k=0;
				for (i=i1;i<=i2;i++){
					for(j=j1;j<=j2;j++){
						temp[k] = arr[i][j];
						k++;
					}
				}
				sub_c = check(temp);
				if (sub_c == false){
					return false;
				}
				j1 = j1+3;
				j2 = j2+3;
			}
			i1 = i1+3;
			i2 = i2+3;
		}
		return true;
	}

	public static void main(String[] args) {
		int sudo_mat[][] = new int [9][9];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values : ");
		for (int i=0;i<9;i++){
			for (int j=0;j<9;j++){
				sudo_mat[i][j] = sc.nextInt();
			}
		}
		if (row_check(sudo_mat)== true && col_check(sudo_mat) && sub_check(sudo_mat) ){
			System.out.println("sudoku matrix");
		}
		else{
			System.out.println("not sudoku matrix");
		}
	}

}
