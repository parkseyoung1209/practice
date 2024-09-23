package dataStructure.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class List {
	ListNode head;

	public List() {
		this.head = null;
	}
	
	
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
	        while (currentNode != null) {
	            System.out.print(currentNode.value + " ");
	            currentNode = currentNode.next;
	        }
	        System.out.println();
	    }
	 
	 
}
