import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DMOJ - Rat in a Maze
//Simple BFS algorithm

public class RatInAMaze {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int size;
	static int[][] maze;
	static boolean[][] visited;

	static Queue<Integer> xq = new LinkedList<Integer>();
	static Queue<Integer> yq = new LinkedList<Integer>();
	
	static boolean exitFound = false;
	
	public static void main(String[] args) throws IOException {
		int size = nextInt();
		
		maze = new int [size][size];
		visited=  new boolean [size][size];
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				maze[row][col] = nextInt();
			}
		}
		
		System.out.println(bfs());
	}

	private static String bfs() {
		xq.add(0);
		yq.add(0);
		
		visited[0][0] = true;
		
		while (!xq.isEmpty() && !exitFound) {
			int x = xq.poll();
			int y = yq.poll();
			explore(x,y);
		}
		
		if (exitFound) {
			return "yes";
		}
		else {
			return "no";
		}
		
	}

	private static void explore(int xStart, int yStart) {
		for (int i = 1; i <= 4; i++) {
			int x = xStart;
			int y = yStart;
			
			switch(i) {
				case 1:
					x++;
					break;
				case 2: 
					x--;
					break;
				case 3:
					y++;
					break;
				case 4:
					y--;
					break;
			}
			
			if (x == maze.length - 1 && y == maze.length - 1) {
				exitFound = true;
			}
			
			else if(x >= 0 && x < maze.length && y >=0 && y < maze.length) {
				if (maze[x][y] == 0 && visited[x][y] != true) {
					xq.add(x);
					yq.add(y);
					visited[x][y] = true;
				}
				else if (maze[x][y] == 1) {
					visited[x][y] = true;
					continue;
					
				}
			}
		}
		
	}

	private static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
		return st.nextToken();
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

}
