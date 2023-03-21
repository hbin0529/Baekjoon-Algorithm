import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
			예제 입력1
			4		// 수열의 크기
			3 5 2 7
			
			예제 출력1
			5 7 7 -1
			
			예제 입력2
			4
			9 5 4 8
			
			예제 출력2
			-1 8 8 -1
		*/
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(buffer.readLine());
		int A[] = new int[n];							// 수열 배열 생성
		int answer[] = new int[n];						// 정답 배열 생성
		String str[] = buffer.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);									// 처음에는 항상 스택이 비어 있으므로 최초 값을 push해 초기화 
		
		for(int i = 1; i < n; i++) {
			//	스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				answer[stack.pop()] = A[i];				// 정답 배열에 오큰수를 현재 수열로 저장하기
			}
			stack.push(i);								// 신규 데이터 push
		}
		while(!stack.empty()) {
			// 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지 돌려줌
			answer[stack.pop()] = -1;
			// 스택에 쌓인 index에 -1 넣고
			
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n; i++) {
			bw.write(answer[i] + " ");
			//출력한다
		}
		bw.write("\n");
		bw.flush();
		
	}

}