import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
			예제 입력 1
			6			// 카드의 개수
			
			예제 출력 1
			4
		*/
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
		
	}

}