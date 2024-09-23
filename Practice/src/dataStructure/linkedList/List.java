package dataStructure.linkedList;

public class List {
	ListNode head;

	public List(ListNode head) {
		this.head = null;
	}
	
	public void add(int value) {
		ListNode node = new ListNode(value);
		if(head == null) {
			head = node;
			return;
		} else {
			ListNode currentNode = head;
			while(currentNode != null) {
				currentNode = currentNode.next;
			}
		}
	}
}
