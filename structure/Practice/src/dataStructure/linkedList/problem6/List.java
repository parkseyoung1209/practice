package dataStructure.linkedList.problem6;

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
	
	public void deleteByValue(int value) {
		if(head == null) {
			System.out.println("리스트 존재하지 않음");
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
			System.out.println("값 입력 잘못");
			return;
		}
		
		previousNode.next = currentNode.next;
	}

}
