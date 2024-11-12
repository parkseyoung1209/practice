package dataStructure.hashMap.problem0;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
		int sameBirthDays = 0;
		
		for(int i =0; i<100000; i++) {
			int[] array = new int[23];
			
			for(int j = 0; j<23; j++) {
				int birthday = ThreadLocalRandom.current().nextInt(1, 365+1);
				if(IntStream.of(array).anyMatch(x -> x == birthday)) {
					sameBirthDays++;
					break;
				}
				array[j] = birthday;
			}
		}
		System.out.println("10만번의 실험 중 생일이 같은 실험의 확률");
		System.out.println((double) sameBirthDays / 100000 * 100);
	}

}
