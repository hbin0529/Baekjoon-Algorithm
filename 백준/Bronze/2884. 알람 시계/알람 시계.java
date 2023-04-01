import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		/*
			예제 입력 1
			10 10
			
			예제 출력 1
			9 25
			
			예제 입력 2
			0 30
			
			예제 출력 2
			23 45
			
			예제 입력 3
			23 40
			
			예제 출력 3
			22 55
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		if(minute < 45) {
			hour--;
			minute = 60 - (45 - minute);
			if(hour < 0) {
				hour = 23;
			}
			System.out.println(hour + " " + minute);
			
		} else {
			System.out.println(hour + " " + (minute - 45));
		}
		
		
	}

}
