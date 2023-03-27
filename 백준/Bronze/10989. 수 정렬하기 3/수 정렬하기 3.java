import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

	/*
	예제 입력 1
	11
	215
	15
	344
	372
	294
	100
	8
	145
	24
	198
	831
	
	예제 출력 1
	8
	15
	24
	100
	145
	198
	215
	294
	344
	372
	831
	*/
public class Main {

	public static int[] A;
	public static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		sort(A, 5);
		
		for(int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	private static void sort(int[] A, int max) {
		int[] arr = new int[A.length];
		int num = 1;
		int cnt = 0;
		while(cnt != max) {					// 최대 자릿수 만큼 반복하기
			int[] box = new int[10];
			for(int i = 0; i < A.length; i++) {
				box[(A[i] / num) % 10]++;		// 1의 자리부터 시작
			}
			
			for(int i = 1; i < 10; i++) {		// 합 배열을 이용해 index 계산하기
				box[i] += box[i - 1];
			}
			
			for(int i = A.length -1; i >= 0; i--) {		// 현재 자리수를 기준으로 정렬하기
				arr[box[(A[i] / num % 10)] - 1] = A[i];
				 box[(A[i] / num) % 10]--;
			}
			
			for(int i = 0; i < A.length; i++) {		// 다음 자리수를 이동하기 위해 현재 자리수 기준 정렬 데이터 저장하기
				A[i] = arr[i];
			}
			num = num * 10;
			cnt++;
		}
	} 

}
