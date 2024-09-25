package dataStructure.linkedList.problem4;

import java.math.BigInteger;

public class LinkedList {

	public static void main(String[] args) {
		LinkedList sample = new LinkedList();
		dataStructure.linkedList.problem2.LinkedList arr = new dataStructure.linkedList.problem2.LinkedList();
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
//		list3.head = sample.addTwoNumber(list1.head, list2.head);
		list3.printList(list3.head);
		
		arr.time();
	}
	
	// 1. 뒤집고 문자열로 바꿔서 더한 다음 다시 리스트로 변경
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
		for(char c : String.valueOf(num).toCharArray()) { // biginteger 그대로 안가져오고 문자열 배열로 가져옴
			node = new ListNode(Character.getNumericValue(c)); // 문자 숫자로 파싱
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
	
	// 2. 전가산기 구현
	public ListNode addTwoNumber(ListNode node1, ListNode node2) { // 각각 2,4,3 / 5,6,2
		ListNode node = new ListNode(0); // 임시 노드 생성
		ListNode root = node; // 실제 출력값, 현재는 root에 0->null 들어가있음
		
		int sum, carry = 0, remainder; 
		/*
		 * sum은 각 자리수 덧셈
		 * carry는 올림자릿수
		 * remainder는 올라온 올림자릿수값 +sum한거 이게 각 자리수별 최종 값임
		 */
		
		while(node1 != null || node2 != null || carry != 0) {
			sum = 0; // 아마 미리 sum 값을 while문 바깥에 빼면 전부더한 sum이 나와서 그런듯..
			
			if(node1 != null) {
				sum += node1.value;
				node1 = node1.next; // 반복분이 긑날때까지의 자리수에 첫번째 리스트 처음값 설정 후 다음 노드로 이동
			}
			
			if(node2 != null) {	
				sum += node2.value;
				node2 = node2.next; // sum에는 이미 2가 있으므로 5를 더해서 최종적으로 현 루프에서 sum은 7
			}
			
			remainder = (sum+carry) % 10; //7
			carry = (sum+carry)/10; // 올림자리수 구하기
			
			node.next = new ListNode(remainder); // 0->7 이라는 리스트 완성
			
			node = node.next; // 다음 노드로 이동, 조건이 아직 안끝났으므로 처음부터 다시.
			/*
			 * 이런식으로 두번째 자리에서 리마인더가 4+6이 되어서 0이 들어가고 캐리쪽은 1이 만들어짐
			 * 이후 sum은 5지만 여기에 carry가 더해지므로 마지막 리마인더는 6이 된다.
			 * 노드 두개도 끝에 다다라서 null이 되고 캐리도 (5+1) / 10 이라 0이되어 조건문이 끝남
			 */
		}
		return root.next; // 마지막에 루트를 뽑는데 루트 그 자체를 뽑으면 0,7,0,6이 나오므로 다음것부터 출력한다.
	}
}
