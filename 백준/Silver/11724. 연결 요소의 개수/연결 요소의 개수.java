import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	/*
	
		예제입력1
		6 5			// 노드 개수, 에지 개수
		1 2
		2 5 
		5 1
		3 4
		4 6
			
		예제출력1
		2
		
		예제 입력2 
		6 8 
		1 2
		2 5 
		5 1
		3 4 
		4 6 
		5 4
		2 4 
		2 3 
		
		예제 출력 2
		1 
	 
	*/

	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 1; i < n + 1; i++) {		// 인접 리스트 초기화하기
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);	// 양방향 에지이므로 양쪽에 에지를 더한다.
			A[e].add(s);	
		}
		
		int cnt = 0;
		
		for(int i = 1; i < n + 1; i++ ) {
			if(!visited[i]) {			// 방문을 하지않은 노드가 없을 때까지 반복하기
				cnt++;
				DFS(i);
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		
		visited[v] = true;
		
		for(int i : A[v]) {
			if(visited[i] == false) {		// 연결한 노드 중 방문을 하지않은 노드 탐색
				DFS(i);
			}
		}
	}

}
