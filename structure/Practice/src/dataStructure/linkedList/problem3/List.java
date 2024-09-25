package dataStructure.linkedList.problem3;

public class List {
	ListNode head;
	
	public List() {
		this.head = null;
	}
	
	public void add(int value) {
		ListNode node = new ListNode(value);
		
		if(head == null) {
			head = node;
			return;		// 값이 없으면 데이터 값 받은 최초의 노드 넣고 리턴
		}
		ListNode currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node; // 이미 있는 노드면 null 가리키는 곳까지 계속 next로 다음꺼 참조 시킨 후 node 값 넣기
	}
	
	public void printList(ListNode node) {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.println(currentNode.value + " ");
			currentNode = currentNode.next;
		}
	}
}
