package dataStructure.linkedList.problem7;

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
	
	public void printList() {
		ListNode node = head;
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	
	public void deleteInValue(int value) {
		if(head == null) {
			return;
		}
		if(head.value == value) {
			head = head.next;
			return;
		}
		
		ListNode currentNode = head;
		ListNode previousNode = null;
		
		while(currentNode != null && currentNode.value != value) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		if(currentNode == null) {
			return;
		}
		previousNode.next = currentNode.next;
	}
}
