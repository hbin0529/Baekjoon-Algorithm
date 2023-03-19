import java.io.*;
import java.util.*;

public class Main {

	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		/*
		 * 예제 입력 1
		 * 12 3 // 숫자의 개수, 슬라이딩 윈도우의 크기
		 * 1 5 2 3 6 2 3 7 3 5 2 6
		 * 
		 * 예제 출력 2
		 * 1 1 1 2 2 2 2 2 3 3 2 2
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			// 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄이자
			
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i));
			// 범위에서 벗어난 값은 덱에서 제거
			if(mydeque.getFirst().index <= i - L) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
