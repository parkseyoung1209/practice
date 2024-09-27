package dataStructure.linkedList.problem6;

public class LinkedList {
	
	public static void main(String[] args) {
		LinkedList oo = new LinkedList();
		
		List list1 = new List();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		List list2 = new List();
		
		list2.head = oo.oddEvenList(list1.head);
		
		list2.printList();
	}
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode odd = head;
		ListNode even = head.next;
		
		ListNode evenHead = even;
		
		while(even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		
		return head;
	}
}
