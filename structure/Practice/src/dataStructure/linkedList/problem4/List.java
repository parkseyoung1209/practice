package dataStructure.linkedList.problem4;

public class List {
	ListNode head;
	
	public void add(int value) {
		ListNode node = new ListNode(value);
		if(head == null) {
			head = node;
			return;
		}
		
		ListNode currentNode = head;
		
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node; 
	}
	
	public void printList(ListNode head) {
		ListNode currentNode = head;
		
		while(currentNode != null) {
			System.out.println(currentNode.value + " ");
			currentNode = currentNode.next;
		}
	}
}
