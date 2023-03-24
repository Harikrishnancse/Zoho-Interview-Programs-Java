import java.util.Scanner;
public class second_code {
	char letter_stack[] = new char[5];
	char number_stack[] = new char[5];                 
	int top_1=-1 , top_2 =-1;

	public void push(char c, char d){
		if(d=='l')
		{
			top_1++;
			letter_stack[top_1]= c;
		}
		else{ // c == 'd'
			top_2++;
			number_stack[top_2]= c;
		}
	}
	
	private String pop_all(char c) {
		String temp = "";
		if (c=='d'){
			while(top_2 != -1){
				temp = number_stack[top_2] + temp;
				top_2--;
			}
		}
		else{ // c == 'l'
			while(top_1 != -1){
				temp=letter_stack[top_1] + temp;
				top_1--;
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		second_code c = new second_code();
		System.out.print("Enter the string : ");
		Scanner sc= new Scanner(System.in);
		String input= sc.nextLine();
		String result ="";
		int i=0;
		while(i<input.length())
		{
			if(input.charAt(i)=='('){
				i++;
				while(input.charAt(i)!=')'){
					c.push(input.charAt(i),'l');
					i++;
				}
				i++;
			}
			else if (input.charAt(i)=='{'){
				i++;
				while(input.charAt(i)!='}'){
					c.push(input.charAt(i),'d');
					i++;
				}
			}
			else if (input.charAt(i)=='}'){
				String let = c.pop_all('l');
				String num = c.pop_all('d');
				int count;
				if(num.charAt(0)=='-'){
					count = Integer.parseInt(String.valueOf(num.charAt(1)));
					String t="";
					for(int ind=0;ind< let.length() ;ind++){
						t+= Character.toUpperCase(let.charAt(ind));
					}
					let = t;
				}
				else{
					count = Integer.parseInt(String.valueOf(num.charAt(0)));
				}
				//doing extraction
				for(int j=0; j<count ; j++){
					result += let;
				}
			   i++;
			}
			else{ //single letter
				result += input.charAt(i);
				i++;
			}
		}
		System.out.println(result);
	}
}
