package dataStructure.stackAndQueue.problem2;

public class Stack {
	public static void main(String[] args) {
//		Solution1 solution = new Solution1();
//		String result = solution.removeDuplicateLetters("dbacdcbc");
		
		Solution2 sol = new Solution2();
		String result = sol.removeDuplicateLetters("dbacdcbc");
		System.out.println(result);
	}
}
