import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
			
			예제입력 1
			10			// 수의 개수
			1 2 3 4 5 6 7 8 9 10
			
			예제출력 1
			8
			
			
			투 포인터 이동 원칙
			1. A[i] + A[j] > K: j--; A[i] + A[j] < K: i++;
			2. A[i] + A[j] == K: i++; j--; count++;
		*/
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buffer.readLine());
		int result = 0;
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(buffer.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		
		for(int k = 0; k < N; k++) {
			long find = A[k];
			int i = 0;
			int j = N - 1;
			// 투 포인터 알고리즘
			while(i < j) {
				if(A[i] + A[j] == find) {
					// find는 서로 다른 두 수의 합이어야 함을 체크
					if(i != k && j != k) {
						result++;
						break;
					} else if(i == k) {
						i++;
					} else if(j == k) {
						j--;
					} 
				} else if(A[i] + A[j] < find) {
					i++;
				} else { 
					j--;
				}
			}
		}
		
		System.out.println(result);
		buffer.close();
		
	}

}
