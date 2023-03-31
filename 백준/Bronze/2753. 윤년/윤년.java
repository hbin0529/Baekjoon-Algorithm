import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
			예제 입력 1
			2000
			
			예제 출력 2
			1
			
			예제 입력 2
			1999
			
			예제 출력 2
			0
		*/
		
		Scanner sc = new Scanner(System.in);
		int yoon = sc.nextInt();
		
		System.out.print((yoon%4==0)?((yoon%400==0)?"1":(yoon%100==0)?"0":"1"):"0");
	}

}
