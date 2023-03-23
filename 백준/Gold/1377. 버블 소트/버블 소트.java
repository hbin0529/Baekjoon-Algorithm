import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException {
		/*
			 예제 입력 1
			 5			// 배열의 크기
			 10
			 1
			 5
			 2
			 3
			 
			 예제 출력 1
			 3
		*/
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buffer.readLine());
		mData A[] = new mData[N];
		for(int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(buffer.readLine()), i);
		}
		Arrays.sort(A);								// A 배열 정렬(O(nlogn) 시간 복잡도)
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			if(max < A[i].index -i)					// 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
				max = A[i].index - i;
		}
		System.out.println(max + 1);
	}

}

class mData implements Comparable<mData> {
	int value;
	int index;
	
	public mData(int value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o) {		// value 기준 오름차순 정렬하기
		return this.value - o.value;
	}
}
