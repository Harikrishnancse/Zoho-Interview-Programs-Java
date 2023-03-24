import java.util.Scanner;
public class reg_exp {
	public static void main(String args[]){
		System.out.print("Enter the string : ");
		Scanner sc= new Scanner(System.in);
		String input= sc.nextLine();
		char arr[] = input.toCharArray();
		String ip ="";
		// Preprocessing
		int i=0;
		while(i<input.length()){
			if (arr[i] != '(' && arr[i] != ')' && arr[i] != '{' && arr[i] != '}' ){
				ip += arr[i];
			}
			i++;
		}
		i=0;
		int count;
		String result="",stack = "" ;
		while(i<ip.length()-1){
			char ch = ip.charAt(i);
			if( Character.isAlphabetic(ch) ){ //a-z ascii values
				if(Character.isAlphabetic(ip.charAt(i+1))){
					result += ch;
				}
				else {
					stack += ch;
				}
			}
			else if (ch == '-') {
				char t = stack.charAt(0);
				t = Character.toUpperCase(t);
				stack = "";
				stack += t;
			}	
			else if(Character.isDigit(ch)){
				count = Integer.parseInt(String.valueOf(ch));
				char c = stack.charAt(0);
				for(int t=0;t<count;t++){
					result += c;
				}
				stack="";
			}
			i++;
		}
		
		if (stack != "" && Character.isDigit( ip.charAt(ip.length()-1))){
			for(int t=0; t<Integer.parseInt(String.valueOf(ip.charAt(i)));t++){
				result += stack.charAt(0);
			}
		}
		if(Character.isAlphabetic(ip.charAt(ip.length()-1))){
			result+=ip.charAt(ip.length()-1);
		}
		
		
		System.out.println(result);
	}
}
