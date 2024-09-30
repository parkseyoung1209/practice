package dataStructure.linkedList.problem7;

public class LinkedList {

	public static void main(String[] args) {
		LinkedList oo = new LinkedList();
		List list = new List();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		List list2 = new List();
		
		list2.head=oo.reverseBetween(list.head, 2, 5);
		
		list2.printList();
	}
	
	public ListNode reverseBetween(ListNode head, int a, int b) {
		if(head == null) {
			return null;
		}
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode start = root;
		
		for(int i = 0; i<a-1; i++) {
			start = start.next;
		}
		ListNode end = start.next;
		for(int i = 0; i<b-a; i++) {
			ListNode tmp = start.next;
			start.next = end.next;
			end.next = end.next.next;
			start.next.next = tmp;
		}
		return root.next;
	}

}
