import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
			예제입력 1
			6
			9
			2 7 4 1 5 3
			
			예제출력 1
			2
		*/
		
		/*
			투 포인터 이동 원칙
			arr[0] + arr[5] = 8 < M = i++
		*/
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buffer.readLine());
		int M = Integer.parseInt(buffer.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(buffer.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int count = 0;
		int i = 0;
		int j = N - 1;
		while(i < j) {
			if(arr[i] + arr[j] < M) {				// arr[i] + arr[j] < M	 =>	 i++
				i++;
			} else if(arr[i] + arr[j] > M) {		// arr[i] + arr[j] > M 	=>	 j--;
				j--;								
			} else {								// arr[i] + arr[j] == M	 =>	 count++; i++; j--;
				count++;
				i++;
				j--;
			}
		}
		
		System.out.println(count);
		buffer.close();
		
	}

}
