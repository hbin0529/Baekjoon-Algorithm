import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		int A = 5;
		int B = 3;
		int C = 4;
		
		(A + B) % C = ((A % C)+(B%C)) % C
		System.out.println((A + B) % C); 			// 0
		System.out.println(((A % C)+(B%C)) % C );	// 0

		예제 입력 1
		5 3
		1 2 3 1 2
		예제 출력 1 
		7
		*/
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();					// 수열의 개수
		int M = sc.nextInt();					// 나누어떨어져야 하는 수
		long S[] = new long[N];					// 합 배열
		long C[] = new long[M];					// 같은 나머지의 인덱스를 카운트하는 배열
		long answer = 0;
		S[0] = sc.nextInt();
		
		for(int i = 1; i < N; i++) {
			S[i] = S[i-1] + sc.nextInt();		// 합 배열 저장
		}
		
		for(int i = 0; i < N; i++) {
			int remain = (int) (S[i] % M);		// 합 배열을 M으로 나눈 나머지 값
			// 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
			if(remain == 0) {
				answer++;						// 정답을 1 증가시키기
			}
			// 나머지가 같은 인덱스의 개수 카운팅하기
			C[remain]++;						// 값을 1 증가 시키기
		}
		
		for(int i = 0; i < M; i++) {
			if(C[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				// C[i]개 중 2개를 뽑는 경우의 수 계산 공식 : C[i] * (C[i] - 1) / 2
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		
		System.out.println(answer);
		
	}
	
}