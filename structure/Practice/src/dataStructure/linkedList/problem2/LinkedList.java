package dataStructure.linkedList.problem2;

public class LinkedList {
		
	public static void main(String[] args) {
		LinkedList arr = new LinkedList();
		List list1 = new List();
		List list2 = new List();
		
		list1.add(1);
		list1.add(2);
		list1.add(5);
		
		list2.add(1);
		list2.add(3);
		list2.add(4);
		
		List list3 = new List();
		list3.head = arr.mergeTwoLists(list1.head, list2.head);
		
		list3.printList();
		arr.time();
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		if(list1.value < list2.value) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
	
	public void time() {
		long startTime = System.nanoTime();

        // 측정하고 싶은 코드
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }

        // 종료 시간 측정
        long endTime = System.nanoTime();

        // 실행 시간 계산
        long executionTime = endTime - startTime;
        System.out.println("코드 실행 시간: " + executionTime + " 나노초");

        // 밀리초 단위로 출력
        System.out.println("코드 실행 시간: " + (executionTime / 1_000_000) + " 밀리초");
	}
}
