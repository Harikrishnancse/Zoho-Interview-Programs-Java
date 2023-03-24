import java.util.Scanner;

public class Translate {
	
	public String convert_email(String email) {
		int len = email.length();
		int i=1,j;
		String new_email = "";
		new_email += email.charAt(0);
		while(email.charAt(i) != '@'){
			 i++;
		}
		new_email += "*****";
		for (j=i;j<len;j++){
			new_email += email.charAt(j);
		}
		return new_email;
	}
	
	public String convert_phone(String phone_no) {
		int len = phone_no.length();
		String new_phone = "";
		int i=0;
		if (phone_no.charAt(i)=='+'){
			new_phone += phone_no.substring(i, i+3);
			i=i+3;
		}
		if (phone_no.charAt(i)==' '){
			i++;
		}
		new_phone += phone_no.charAt(i);
		i++;
		int count=0;
		while(i<len){
			if (phone_no.charAt(i)!=' '){
				if (count<5)
				{
					new_phone += '*';
					count++;
					
				}
				else
					new_phone += phone_no.charAt(i);
			}
			i++;
		}
		return new_phone;
	}

	public static void main(String[] args) {
		Translate trans = new Translate();
		String email,phone_no;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Email Id : ");
		email = sc.nextLine();
		System.out.print("Enter the Phone No : ");
		phone_no = sc.nextLine();
		email = trans.convert_email(email);
		phone_no = trans.convert_phone(phone_no);
		System.out.println("\n New Email Id  : "+ email);
		System.out.println("New Phone No  : "+ phone_no);
	}

}
