import java.util.Scanner;

public class Main {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		String path = "result.txt";
		int n = 0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		new SetAQuestion(n,path,"201571030301");
		System.out.println("Íê³É");
	}
}
