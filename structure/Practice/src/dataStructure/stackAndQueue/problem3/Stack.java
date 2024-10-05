package dataStructure.stackAndQueue.problem3;

import java.util.Arrays;

public class Stack {
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[] temperatures = {23, 24, 25,21,19,22,26,23};
		sol.dailyTemperatures(temperatures);
		
		System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));
	}
}
