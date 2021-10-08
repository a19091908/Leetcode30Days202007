package leetCodeJuly2020;

public class FlattenAMultilevelDoublyLinkedList10 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node node3 = head.next.next;
		node3.next = new Node(4);
		
		node3.child = new Node(7);
		node3.child.next = new Node(8);
		
		Node node8 = node3.child.next;
		node8.next = new Node(9);
		node8.child = new Node(11);
		node8.child.next = new Node(12);
		
		Node ansNode = new FlattenAMultilevelDoublyLinkedList10().flatten(head);
		
		Node tempNode = ansNode;
		while (tempNode != null) {
			System.out.print(tempNode.val + ", ");
			tempNode = tempNode.next;
		}

	}

	private Node flatten(Node head) {
		
		doFlat(head);
		
		return head;
	}

	private Node doFlat(Node node) {
		if (node != null) {
			Node nextNode = node.next;

			if (node.child != null) {
				node.next = node.child;
				node.child.prev = node;
				node.child = null;
				node = doFlat(node.next);
			}
			
			node.next = nextNode;
			if (nextNode != null) {
				nextNode.prev = node;
				node = doFlat(nextNode);
			}

		}
		
		return node;
		
	}

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(){

    }
    Node(int val){
    	this.val = val;
    }
};