package dataStructure.linkedList.problem4;

import java.math.BigInteger;

public class LinkedList {

	public static void main(String[] args) {
		LinkedList sample = new LinkedList();
		List list1 = new List();
		List list2 = new List();
		
		List list3 = new List();
		
		list1.add(2);
		list1.add(4);
		list1.add(3);
		
		list2.add(5);
		list2.add(6);
		list2.add(2);
		
		
		list3.head = sample.addNumList(list1.head, list2.head);
		
		list3.printList(list3.head);
	}
	// 각각 연결 리스트 뒤집기
	public ListNode reverseList(ListNode head) {
		ListNode prev = null, node = head;
		while(node != null) {
			ListNode next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
	}
	// 숫자로 만들기(예제에서는 수 오지게 크다고 biginteger씀)
	public BigInteger toBigInt(ListNode node) {
		String text = "";
		while(node != null) {
			text = text+node.value; //`int` 타입의 `value`가 자동으로 `String`으로 변환되어 연결됨
			node = node.next;
		}
		
		return new BigInteger(text); // biginteger도 클래스다.. 여기에 있는 생성자중에 파싱 기능이 있음..
		// 주의사항으로는 문자열'만' 있어야함 123abc 이런식으로 섞인건 답없음
	}
	// 결과값 다시 역순으로 리스트 만들기
	public ListNode toReversedList(BigInteger num) {
		ListNode prev = null, node = null;
		for(char c : String.valueOf(num).toCharArray()) {
			node = new ListNode(Character.getNumericValue(c));
			node.next = prev;
			prev = node;
		}
		return prev;
	}
	// 위에 매서드 종합해서 결과내기
	public ListNode addNumList(ListNode node1, ListNode node2) {
		ListNode n1 = reverseList(node1);
		ListNode n2 = reverseList(node2);
		
		BigInteger result = toBigInt(n1).add(toBigInt(n2));
		
		ListNode good = toReversedList(result);
		return good;
	}
}
