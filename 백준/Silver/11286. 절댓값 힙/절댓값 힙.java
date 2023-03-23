import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException{
		/*
			예제 입력 1
			18		// 연산의 개수
			1
			-1
			0
			0
			0
			1
			1
			-1
			-1
			2
			-2
			0
			0
			0
			0
			0
			0
			
			예제 출력 1
			-1
			1
			0
			-1
			-1
			1
			1
			-2
			2
			0
		*/
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buffer.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs)				// 절댓값이 같으면 음수 우선 정렬하기
				return o1 > o2 ? 1 : -1;
			else
				return first_abs - second_abs;		// 절댓값을 기준으로 정렬하기
		});
		
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(buffer.readLine());
			if(request == 0) {
				if(queue.isEmpty())
					System.out.println("0");
				else 
					System.out.println(queue.poll());
			} else {
				queue.add(request);
			}
		}
	}

}
