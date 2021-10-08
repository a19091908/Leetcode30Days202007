package leetCodeJuly2020;

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree9 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, 
				new TreeNode(3, new TreeNode(5), new TreeNode(3)), 
				new TreeNode(2, null, new TreeNode(9)));
		
		int ans = new MaximumWidthOfBinaryTree9().widthOfBinaryTree(root);
		System.out.println(ans);
	}

	private int widthOfBinaryTree(TreeNode root) {
		LinkedList<Integer> startList = new LinkedList<>();
		LinkedList<Integer> endList = new LinkedList<>();
		
		dfs(root,0,1,startList,endList);
		
		int ans = findLongestWidth(startList,endList);
		
		return ans;
	}

	private int findLongestWidth(LinkedList<Integer> startList, LinkedList<Integer> endList) {
		int longestWidth = -1;
		int size = startList.size();
		
		for (int i = 0; i < size; i++) {
			longestWidth = Math.max(longestWidth,endList.get(i)-startList.get(i)+1);
		}
		
		return longestWidth;
	}

	private void dfs(TreeNode node, int level, int order, LinkedList<Integer> startList, LinkedList<Integer> endList) {
		if (node == null) return;
		
		if (startList.size()==level) {
			startList.add(order);
			endList.add(order);
		}else {
			endList.set(level, order);
		}
		
		dfs(node.left, level+1, order*2, startList, endList);
		dfs(node.right, level+1, order*2+1, startList, endList);
	}

}
