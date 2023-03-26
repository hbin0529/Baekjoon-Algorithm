import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
			예제 입력 1
			8		// 수의 개수
			3 2 8 1 7 4 5 6 
			
			예제 출력 1
			11		// 버블 소트가 몇번 발생하는지
 */

public class Main {
	
	public static int[] A, tmp;
	public static long result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 정렬할 수 개수 
		A = new int[N + 1];								// 정렬할 배열
		tmp = new int[N + 1];							// 정렬에 필요한 임시 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		merget_sort(1, N);			// 뵹햡 정렬 수행하기
		System.out.println(result);
		
	}
	private static void merget_sort(int s, int e) {
		if(e - s < 1) 
			return;
		int m = s + (e - s) / 2;
		// 재귀 함수 형태로 구현하기
		merget_sort(s, m);
		merget_sort(m + 1, e);
		
		for(int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		
		while(index1 <= m && index2 <= e) {			// 두 그룹을 병합하는 로직
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				result = result + index2 - k;		// 뒤쪽 데이터 값이 작은 경우 result 업데이트
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		
		while(index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		
		while(index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}

	
}
