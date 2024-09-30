package dataStructure.stackAndQueue.problem1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Stack {
	// 올바른 괄호 사용을 했는지에 대한 테스트

	public static void main(String[] args) {
		Stack oo = new Stack();
		String text = "[{})({";
		System.out.println(oo.isValid(text));
	}
	public boolean isValid(String text) {
		Deque<Character> stack = new ArrayDeque<Character>();
		
		Map<Character, Character> table = new HashMap<Character, Character>();
		table.put(')', '(');
		table.put('}', '{');
		table.put(']', '[');
		
		for(int i = 0; i<text.length(); i++) {
			if(!table.containsKey(text.charAt(i))) {
				stack.push(text.charAt(i));
			} else if(stack.isEmpty() || table.get(text.charAt(i)) != stack.pop()) { // pop에서 기존에 푸쉬한 값이 비교되면서 제거된다.
				return false;
			}
		}
		return stack.size() == 0;
	}
}
