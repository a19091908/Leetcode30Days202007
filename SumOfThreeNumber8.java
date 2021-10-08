package leetCodeJuly2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeNumber8 {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> ansList = new SumOfThreeNumber8().threeSum(nums);
		
		printListList(ansList);
	}

	private List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ansList = new ArrayList<>();
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length-2; i++) {
			if (i!=0 && nums[i-1] == nums[i]) 
				continue;
			int l = i+1, r = nums.length - 1, sum = 0 - nums[i];
            while(l < r){
                if(nums[l] + nums[r] == sum) {
                	ansList.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while(r > l && nums[l] == nums[l-1])l++;
                    while(r > l && nums[r] == nums[r+1])r--;
                }else if(nums[l] + nums[r] > sum){
                    r--;
                }else{
                    l++;
                }
            }
			
		}

		return ansList;
	}
	
	private static void printListList(List<List<Integer>> ansList) {
		int size = ansList.size();
		for (int i = 0; i < size; i++) {
			List<Integer> list = ansList.get(i);
			int n = list.size();
			for (int j = 0; j < n; j++) {
				System.out.print(list.get(j)+", ");
			}
			System.out.println();
		}
	}

}
