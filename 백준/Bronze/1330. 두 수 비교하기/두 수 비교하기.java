import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
			예제 입력 1
			1 2
			10 2
			5 5
			
			예제 출력 1
			<
			>
			==
		*/
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A < B) {
			System.out.println("<");
		} else if(A > B) {
			System.out.println(">");
		} else {
			System.out.println("==");
		}
	}

}
