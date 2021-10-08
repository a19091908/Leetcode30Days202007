package leetCodeJuly2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,new TreeNode(9), null);
		root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
		List<List<Integer>> list = new BinaryTreeLevelOrderTraversalII2().levelOrderBottom(root);
		
		printListList(list);
	}

	private List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) return new LinkedList<>();
		
		List<List<Integer>> ansList = new LinkedList<>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
	
		while (!queue.isEmpty()) {
			List<Integer> intList = new ArrayList<Integer>();
			
			int queueSize = queue.size();
			
			for (int i = 0; i < queueSize; i++) {
				TreeNode tempNode = queue.remove();
				
				intList.add(tempNode.val);
				
				if (tempNode.left != null) 
					queue.add(tempNode.left);
				if (tempNode.right != null) 
					queue.add(tempNode.right);

			}
			
			ansList.add(0, intList);
		}
		
		return ansList;
	}
	
	private static void printListList(List<List<Integer>> list) {
		int sizeList = list.size();
		for (int i = 0; i < sizeList; i++) {
			List<Integer> tempList = list.get(i);
			int sizeListList = tempList.size();
			for (int j = 0; j < sizeListList; j++) {
				System.out.print(tempList.get(j) + " ");
			}
			System.out.println();
		}
	}

}


// * Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

