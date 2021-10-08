package leetCodeJuly2020;

public class IslandPerimeter7 {

	public static void main(String[] args) {
		int[][] grid = {
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 0, 0 } };
		
		int ans = new IslandPerimeter7().islandPerimeter(grid);
		System.out.print(ans);
	}

	private int islandPerimeter(int[][] grid) {
		int startX = -1, startY = -1;
		
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				if (grid[i][j] == 1) {
//					startX = i;
//					startY = j;
//				}
//			}
//		}
//		
//		int ans = computePerimeter(startX,startY,grid);
		
		int ans = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int perimeter = 4;
				if (grid[i][j] == 1) {
					if (i-1 >= 0 && grid[i-1][j] == 1) {
						perimeter--;
					}
					if (i+1 < grid.length && grid[i+1][j] == 1) {
						perimeter--;
					}
					if (j-1 >= 0 && grid[i][j-1] == 1) {
						perimeter--;
					}
					if (j+1 < grid[0].length && grid[i][j+1] == 1) {
						perimeter--;
					}
					ans += perimeter;
				}
				
			}
		}
		
		return ans;
	}

	private int computePerimeter(int x, int y, int[][] grid) {
		if ( ( x < 0 && x > grid.length-1 && y < 0 && y > grid[0].length-1 )
				&& ( grid[x][y] == 2 || grid[x][y] == 0) ) {
			return 0;
		}
		
		grid[x][y] = 2;
		
		int perimeter = 4;
		int sum = 0;
		if (x-1 >= 0) {
			if(grid[x-1][y] != 0) perimeter--;
			if(grid[x-1][y] == 1) sum = computePerimeter(x-1, y, grid);
		}
		if (x+1 < grid.length) {
			if(grid[x+1][y] != 0) perimeter--; 
			if(grid[x+1][y] == 1) sum = computePerimeter(x+1, y, grid);
		}
		if (y-1 >= 0) {
			if(grid[x][y-1] != 0) perimeter--;
			if(grid[x][y-1] == 1) sum = computePerimeter(x, y-1, grid);
		}
		if (y+1 < grid[0].length) {
			if(grid[x][y+1] != 0) perimeter--; 
			if(grid[x][y+1] == 1) sum = computePerimeter(x, y+1, grid);
		}

		return sum + perimeter;
	}

}
