package dataStructure.stackAndQueue.problem4;

public class Stack {

	public static void main(String[] args) {
	
		Solution1 sol = new Solution1();
		sol.push(1);
		sol.push(2);
		sol.push(3);
		
		System.out.println(sol.pop());
		System.out.println(sol.top());
		System.out.println(sol.empty());
	}

}
