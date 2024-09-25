package dataStructure.linkedList.problem3;


public class LinkedList {

	public static void main(String[] args) {
		LinkedList arr = new LinkedList();
		dataStructure.linkedList.problem2.LinkedList arr2 = new dataStructure.linkedList.problem2.LinkedList();
		List list1 = new List();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		list1.printList(list1.head);
		System.out.println("");
		
		ListNode reverseNode = arr.reverseList(list1.head);
		List list2 = new List();
		
		list2.head = reverseNode;
		
		list2.printList(list2.head);
		arr2.time();
	}
	public ListNode reverse(ListNode node, ListNode prev) {
		if(node == null) {
			return prev;
		}
		
		ListNode next = node.next;
		node.next = prev;
		
		return reverse(next, node);
	}
	
	public ListNode reverseList(ListNode head) {
		return reverse(head, null);
	}
	
	
	public ListNode loopReverseList(ListNode head) {
		ListNode prev = null, node = head;
		
		while(node != null) {
			ListNode next = node.next; // 2
			node.next = prev; // null을 가리킴
			prev = node; // prev는 1
			node = next;
		}
		return prev;
	}
}
