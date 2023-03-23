import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
			예제 입력 1
			2143
			
			예제 출력 1
			4321
		*/
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int A[] = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		
		for(int i = 0; i < str.length(); i++) {
			int max = i;
			for(int j = i + 1; j < str.length(); j++) {
				if(A[j] > A[max])						// 내림차순이므로 최댓값을 찾음
					max = j;
			}
			if(A[i] < A[max]) {
				int temp = A[i];
				A[i] = A[max];
				A[max] = temp;
			}
		}
		
		for(int i = 0; i < str.length(); i++) {
			System.out.print(A[i]);
		}
		
	}

}
