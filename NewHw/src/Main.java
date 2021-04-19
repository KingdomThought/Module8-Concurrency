import java.util.Random;

public class Main {
	public static void main(String[] args) {
		//Here We Create A Random object from the Class Random
		Random randomObject = new Random();
		//Here An Array is created called arr --- with a legnth of 2 million
		int[] randomNumArray = new int[200000000];
		for (int i = 0; i < randomNumArray.length; i++) {
			randomNumArray[i] = randomObject.nextInt(10) + 1;
		}
		long start = System.currentTimeMillis();
		System.out.println("The sum of The Radomly Generated numbers in this array is " + SumClass.sum(randomNumArray));
		System.out.println("The Single Thread Sum Array took  " + (System.currentTimeMillis() - start) + " milli seconds to execute"   );
		start = System.currentTimeMillis();
		System.out.println("The sum of The Radomly Generated numbers in this array is " + SumClass.parallelSum(randomNumArray));
		System.out.println("The Parallel Sum Array  took " + (System.currentTimeMillis() - start) + " milli seconds to execute");
	}
}
 