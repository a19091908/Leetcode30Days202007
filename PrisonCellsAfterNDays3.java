package leetCodeJuly2020;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellsAfterNDays3 {

	public static void main(String[] args) {
		int[] cells = {0,1,0,1,1,0,0,1};
		int N = 7;
		int[] ans = new PrisonCellsAfterNDays3().prisonAfterNDays(cells,N);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + ", ");
		}
	}

	private int[] prisonAfterNDays(int[] cells, int N) {
		if (cells == null || N <= 0) return cells;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put(Arrays.toString(cells), 0);
		
		boolean isfindCycle = false;
		int cycleStart = 0, cycleEnd = 0;
		
		for (int i = 1; i <= N; i++) {
			int[] nextCells = findNextCells(cells);
			String nextStr = Arrays.toString(nextCells);
			if (!map.containsKey(nextStr)) {
				map.put(nextStr, i);
			}else {
				isfindCycle = true;
				cycleStart = map.get(nextStr);
				cycleEnd = i-1;
				break;
			}
			cells = nextCells;
		}
		
		if (isfindCycle) {
			int nOfCycle = (N-cycleEnd)%(cycleEnd-cycleStart+1);
			for (int i = 0; i < nOfCycle; i++) {
				cells = findNextCells(cells);
			}
		}
		
		return cells;
	}

	private int[] findNextCells(int[] cells) {
		int[] tempArr = new int[8];
		
		for (int i = 1; i < tempArr.length-1; i++) 
			tempArr[i] = (cells[i-1] - cells[i+1]) == 0 ? 1 : 0 ;		
		
		return tempArr;
	}



}
