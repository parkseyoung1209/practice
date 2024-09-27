package dataStructure.linkedList.problem5;

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
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	 // 추가된 기능 1: 특정 노드 삭제 (노드에 대한 참조가 있는 경우)
    /*public void deleteNode(ListNode nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            System.out.println("이 노드를 삭제할 수 없습니다.");
            return;
        }

        // 다음 노드의 데이터를 현재 노드로 복사하고 다음 노드를 건너뜁니다.
        nodeToDelete.value = nodeToDelete.next.value;
        nodeToDelete.next = nodeToDelete.next.next;
    }*/
	// 참조를 아는 경우
	public void delete(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		head.value = head.next.value;
		head.next = head.next.next;
	}
	
	// 참조를 모르는 경우 값으로 찾기
	public void searchDelete(int value) {
		if(head == null) {
			System.out.println("리스트가 존재하지 않음");
			return;
		}
		
		if(head.value == value) {
			head = head.next;
			return; // 이 경우에도 끝내야해서 리턴
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
