package dataStructure.linkedList.problem5;

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
		
//		list.printList();
		
		List list2 = new List();
		
//		list2.head = oo.swapPairs(list.head); // 값만 바꾸기
//		list2.head = oo.swapPairs2(list.head);
		list2.head = oo.swapPairs3(list.head); // 재귀 방식
		list2.printList();
	}
	// 값만 교환
	public ListNode swapPairs(ListNode head) {
		ListNode node = head;
		
		while(node != null && node.next != null) {
			int tmp;
			tmp = node.value;
			node.value = node.next.value;
			node.next.value = tmp;
			node = node.next.next;
		}
		return head; // 여기서 객체 그 자체가 복사되는게 아니라 객체의 주소가 복사된다는 개념을 잊으면 안된다.
	}
	// 반복 구조로 스왑
	public ListNode swapPairs2(ListNode head) {
		ListNode node = new ListNode(0);
		ListNode root = node;
		
		node.next = head;
		
		while(node.next != null && node.next.next != null) {
			ListNode a = node.next;
			ListNode b = node.next.next;
			
			a.next = b.next;
			node.next = b;
			node.next.next = a;
			node = node.next.next;
		}
		return root.next;
	}
	
	// 재귀 구조로 스왑
	public ListNode swapPairs3(ListNode head) {
		if(head != null && head.next != null) {
			ListNode p = head.next;
			head.next = swapPairs3(head.next.next);
			p.next = head;
			return p;
		}
		return head;
	}
}
