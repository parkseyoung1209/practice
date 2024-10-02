package dataStructure.stackAndQueue.problem2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	
	public String removeDuplicateLetters(String s) {
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		Map<Character, Boolean> seen = new HashMap<Character, Boolean>();
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(char c : s.toCharArray()) {
			counter.put(c, counter.get(c) == null ? 1 : counter.get(c)+1);
		}
		
		for(char c : s.toCharArray()) {
			counter.put(c, counter.get(c)-1);
			if(seen.get(c) != null && seen.get(c) == true) continue;
			
			while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
				seen.put(stack.pop(), false);
			}
			stack.push(c);
			seen.put(c, true);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		
		return sb.toString();
	}

}
