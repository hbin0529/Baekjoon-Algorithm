import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int checkArr[];
	static int myArr[];
	static int checkSecret;


	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
			예체입력 1
			9 8			// DNA 문자열의 길이, 부분 문자열의 길이
			CCTGGATTG	// DNA 문자열
			2 0 1 1		// 부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수
			
			예제출력 1 
			0 
			
			예제 입력 2
			4 2
			GATA
			1 0 0 1
			
			예제 출력 2
			2
		*/
		

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buffer.readLine());
		int S = Integer.parseInt(st.nextToken());		// 문자열 크기 
		int P = Integer.parseInt(st.nextToken());		// 부분 문자열의 크기
		int result = 0;									// 결과 값
		char A[] = new char[5];							// 문자열 데이터 
		checkArr = new int[4];							// 비밀번호 체크 배열
		myArr = new int[4];								// 현재 상태 배열
		checkSecret = 0;								// 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수
		A = buffer.readLine().toCharArray();
		st = new StringTokenizer(buffer.readLine());
		for(int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) {
				checkSecret++;
			}
		}
		for(int i = 0; i < P; i++) {		// 초기 P 부분 문자열 처리 부분
			Add(A[i]);
		}
		if(checkSecret == 4)
			result++;
		// 슬라이딩 윈도우 처리 부분
		for(int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if(checkSecret == 4)			// 4자리수와 관련된 크기가 모두 총족될 때 유효한 비밀번호
				result++;
		}
		System.out.println(result);
		buffer.close();
	}
	
	// 별도 함수(문자 더하기 함수)
	private static void Add(char c) {		// 새로 들어온 문자를 처리하는 함수
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0])
				checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3])
				checkSecret++;
			break;
		}
	}
	
	// 문자 빼기 함수
	private static void Remove(char c) {		// 제거되는 문자를 처리하는 함수
		switch(c) {
			case 'A':
				if(myArr[0] == checkArr[0])
					checkSecret--;
				myArr[0]--;
				break;
			case 'C':
				if(myArr[1] == checkArr[1])
					checkSecret--;
				myArr[1]--;
				break;
			case 'G':
				if(myArr[2] == checkArr[2])
					checkSecret--;
				myArr[2]--;
				break;
			case 'T':
				if(myArr[3] == checkArr[3])
					checkSecret--;
				myArr[3]--;
				break;
		}
	}
	
}