import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		예제 입력 1
		3 3 6
		예제 출력 1
		1300
		
		예제 입력 2
		2 2 2
		예제 출력 2
		12000
		
		예제 입력 3
		6 2 5
		예제 출력 3
		600
	*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int a, b, c;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
 
		// 만약 모든 변수가 다른 경우
		if (a != b && b != c && a != c) {
			int max;
			// 만약 a > b 라면
			if (a > b) {
				// c > a > b 라면
				if (c > a) {
					max = c;
				} 
				// a > (b, c)
				else {
					max = a;
				}
			}
			// b > a 라면	
			else {
				// c > b > a 라면
				if (c > b) {
					max = c;
				}
				// b > (a, c)
				else {
					max = b;
				}
			}
			System.out.println(max * 100);
		}
		// 적어도 한 쌍 이상의 서로 같은 변수가 존재할 경우
		else {
			// 3개의 변수가 모두 같은 경우
			if (a == b && a == c) {
				System.out.println(10000 + a * 1000);
			}
			else {
				// a가 b혹은 c랑만 같은 경우
				if(a == b || a == c) {
					System.out.println(1000 + a * 100);
				}
				// b가 c랑 같은 경우
				else {
					System.out.println(1000 + b * 100);
				}
			}
		}
	}
}