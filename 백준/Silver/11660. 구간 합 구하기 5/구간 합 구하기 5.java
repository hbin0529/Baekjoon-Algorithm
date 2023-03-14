import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int D[][] = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 구간 합 구하기
				D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());	//질의 계산
			int y1 = Integer.parseInt(st.nextToken());	//질의 계산
			int x2 = Integer.parseInt(st.nextToken());	//질의 계산
			int y2 = Integer.parseInt(st.nextToken());	//질의 계산
			
			// 구간 합 배열로 질의에 답변하기
			int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1-1];
			System.out.println(result);
			
			/*
			 * 예제입력1
			 * 4 3 			// 2차원 배열의 크기, 구간 합 질의의 개수
			 * 1 2 3 4 		// 원본 배열 1번째 줄
			 * 2 3 4 5 		// 원본 배열 2번째 줄
			 * 3 4 5 6		// 원본 배열 3번째 줄
			 * 4 5 6 7		// 원본 배열 4번째 줄
			 * 2 2 3 4 		// 구간 합(x1, y1),(x2,y2)
			 * 3 4 3 4  	// 구간 합(x1, y1),(x2,y2)
			 * 1 1 4 4  	// 구간 합(x1, y1),(x2,y2)
			 * 
			 * 예제출력1
			 * 27
			 * 6
			 * 64
			 * */
		}
	}

}
