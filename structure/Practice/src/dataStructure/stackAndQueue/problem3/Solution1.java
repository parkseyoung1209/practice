package dataStructure.stackAndQueue.problem3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
	//23 24 25 21 19 22 26 23
	public int[] dailyTemperatures(int[] temperartures) {
		
		int[] result = new int[temperartures.length]; // 결과 배열
		
		Deque<Integer> stack = new ArrayDeque<Integer>(); // 스택 생성
		
		for(int i=0; i<temperartures.length; i++) { // 기존 배열 크기만큼 반복분 돌려야함
			while(!stack.isEmpty() && temperartures[i] > temperartures[stack.peek()]) {
				int last = stack.pop();
				result[last] = i - last; // 이후 기존 정수 배열의 1번 인덱스와 스택에서 뽑은 0 인덱스를 비교하고
				// 크기가 크다면 스택의 실제 값과 i를 뺀 값을 결과 배열에 넣음
				// 이렇게 되면 결과 배열에 비교 원소가 어느 정도로 이동해야 높은게 나오는지 알게됨
			} // 당연히 처음에는 스택이 비어있으니 스택에 0이 들어감
			stack.push(i);
		}
		return result;
	}
}
