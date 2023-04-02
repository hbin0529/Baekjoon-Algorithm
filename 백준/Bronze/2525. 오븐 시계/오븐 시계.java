import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
			예제 입력 1
			14 30
			20
			
			예제 출력 1
			14 50
			
			예제 입력 2
			17 40
			80
			
			예제 출력 2
			19 0
			
			예제 입력 3
			23 48
			25
			
			예제 출력 3
			0 13
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();		// 시 변수 
		int B = sc.nextInt();		// 분 변수
		int C = sc.nextInt();		// 계산할 분 입력 변수
		
		int m = 60 * A + B;			// 입력한 시를 분으로 계산
		m += C;						// 분으로 계산한 시간에 더할 변수
		
		int hour = (m / 60) % 24;
		int minute = m % 60;
		
		System.out.println(hour + " " + minute);
	}

}
