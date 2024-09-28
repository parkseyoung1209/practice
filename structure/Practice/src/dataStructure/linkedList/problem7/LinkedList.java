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
		list2.head = oo.reverseBetween(list.head, 2, 5);
		
		list2.printList();
	}
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(head == null) {
			return null;
		}
		
		ListNode root = new ListNode(0);
		
		root.next = head;
		
		ListNode start = root;
		
		for(int i=0; i < left-1; i++) {
			start = start.next;
			System.out.println(start.value);
			System.out.println("");
		}
		
		ListNode end = start.next;
		System.out.println(end.value);
		System.out.println("");
		
		//start == 1, end == 2
		for(int i =0; i <right - left; i++) { // 3회 실시
			ListNode tmp = start.next; //2 / 3 / 4
			System.out.println(tmp.value + " : tmp값");
			start.next = end.next; // 1->3/ 1->4 / 1->5
			System.out.println(start.next.value + " : start.next값");
			end.next = end.next.next; // 2->4 // 2->5 // 2->6
			System.out.println(end.next.value + " end.next값");
			start.next.next = tmp; // 3->2 // 4->3 // 1->5->4
			System.out.println(start.next.next.value + " : start.next.next값");
			System.out.println(""); // 1-3-2-4-5-6 / 1-4-3-2-5-6 // 1->5->4->3->2->6
		}
		
		return root.next;
	}
}
