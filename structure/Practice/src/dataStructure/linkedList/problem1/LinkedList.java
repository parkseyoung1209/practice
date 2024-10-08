package dataStructure.linkedList.problem1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LinkedList {
	/* "선형 자료구조"는 데이터가 연속적이고 일렬로 나열된 구조를 의미
	 * 
	 * 선형 자료구조의 특징
		1. 순차적인 접근: 데이터가 연속적으로 나열되어 있어 한 번에 하나씩 접근할 수 있습니다.
		2. 삽입 및 삭제의 위치: 특정 위치에 데이터를 추가하거나 제거할 수 있으며, 이 작업은 연결 리스트처럼 구조에 따라 효율성이 달라집니다.
		3. 공간 활용: 데이터가 순서대로 배치되기 때문에 메모리를 효율적으로 사용할 수 있습니다.
	 * 
	 * 
	 * 
	 * 연결 리스트(Linked List)
	 * - 선형 자료구조 중 하나로, 각 원소가 노드(node)라는 개체로 구성되며, 각 노드는 데이터와 다음 노드의 주소를 포함함.
	 * - 동적 메모리 할당을 사용하며, 삽입과 삭제가 효율적이지만, 인덱스를 통한 랜덤 접근이 불가능함.
	 * 
	 * 주요 특징
	 * 1. 동적 메모리 할당: 필요할 때마다 노드를 생성하여 메모리 사용이 효율적임.
	 * 2. 삽입과 삭제의 효율성: 특정 위치에서의 삽입과 삭제가 빠름.
	 * 3. 랜덤 접근 불가: 첫 노드부터 순차적으로 접근해야 함.
	 * 
	 * 종류
	 * 1. 단일 연결 리스트 (Singly Linked List): 각 노드는 데이터와 다음 노드의 주소를 가짐.
	 * 2. 이중 연결 리스트 (Doubly Linked List): 각 노드는 이전 노드와 다음 노드의 주소를 모두 가짐.
	 * 3. 원형 연결 리스트 (Circular Linked List): 마지막 노드가 첫 번째 노드를 가리켜 순환 구조를 형성함.
	 * 
	 * 주요 연산
	 * 1. 삽입 (Insertion): 새로운 노드를 리스트의 처음, 중간, 끝에 추가함.
	 * 2. 삭제 (Deletion): 특정 위치의 노드를 제거함.
	 * 3. 탐색 (Search): 리스트를 순회하며 특정 데이터를 찾음.
	 * 4. 갱신 (Update): 특정 노드의 데이터를 변경함.
	 * 
	 * 구현 시 주의할 점
	 * 1. 노드의 Null 처리: 마지막 노드의 다음 참조를 항상 Null로 설정하여 오류를 방지.
	 * 2. 노드 연결 및 해제: 삽입, 삭제 시 기존 노드의 연결을 잘 관리해야 함.
	 * 
	 * 시간 복잡도
	 * - 삽입/삭제: O(1) (노드 참조를 알고 있는 경우)
	 * - 탐색: O(n) (특정 값을 찾기 위해 전체 리스트를 순회해야 함)
	 */

	
	
	
	// 숫자 5개를 입력받아 팰린드롬 구조인지 판별
	public static void main(String[] args) {
		LinkedList arr = new LinkedList();
		List list = new List();
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		while(count<5) {
			int num = Integer.parseInt(sc.nextLine());
			list.add(num);
			count++;
		}
//		boolean abc = arr.checkByLinkedList(list.head);
		boolean abc = arr.checkRunner(list.head);
		System.out.println(abc);
	}
	
	public boolean check(ListNode head) {
		//Stack<Integer> stack = new Stack<>();
		Deque<Integer> stack = new ArrayDeque<Integer>();
		ListNode node = head;
		while(node != null) {
			stack.push(node.value); 
			// 기존 stack 사용시 add를 써도 후입선출이 가능하나 deque를 쓰면 add가 큐의 add처럼 쓰이기 때문에
			// 1,2,3,4,5를 출력하면 그대로 1,2,3,4,5가 나와 연결리스트와 비교시 무조건 true가 뜬다.
			node = node.next;
		}
		
		while(head != null) {
			if(head.value != stack.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public boolean checkByLinkedList(ListNode head) {
		
		Deque<Integer> deque = new java.util.LinkedList<Integer>();
		ListNode node = head;
		while(node != null) {
			deque.push(node.value);
			node = node.next;
		}
		
		while(!deque.isEmpty() && deque.size() >1) {
			if(deque.pollFirst() != deque.pollLast()) return false;
			// 자바의 데큐 컬렉션은 시작과 끝에서 모두 추출 가능한 자료구조이다.
			// 여기서 pollfirst와 pollLast는 이름처럼 처음과 끝을 빼는 매서드이다. 		
		}
		return true;
	}
	
	public boolean checkRunner(ListNode head) {
		ListNode fast = head , slow = head; // 같은 값에 같은 타입의 변수는 콤마로 지정 가능
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		ListNode rev = null;
		while(slow != null) {
			ListNode node2 = slow.next;
			slow.next = rev;
			rev = slow;
			slow = node2;
		}
		
		while(rev!= null) {
			if(rev.value != head.value) {
				return false;
			}
			rev = rev.next;
			head = head.next;
		}
		return true;
	}
}
