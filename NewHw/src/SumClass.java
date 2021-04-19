
class SumClass extends Thread {
	private int[] array;
	private int low, high, partialSum;

	public SumClass(int[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = Math.min(high, array.length);
	}

	public int getPartialSum() {
		return partialSum;
	}

	public void run() {
		partialSum = sum(array, low, high);
	}

	public static int sum(int[] arr) {
		return sum(arr, 0, arr.length);
	}

	public static int sum(int[] arr, int low, int high) {
		int total = 0;
		for (int i = low; i < high; i++) {
			total += arr[i];
		}
		return total;
	}

	public static int parallelSum(int[] arr) {
		return parallelSum(arr, Runtime.getRuntime().availableProcessors());
	}

	public static int parallelSum(int[] arr, int threads) {
 		int size = (int) Math.ceil(arr.length * 1.0 / threads);
		SumClass[] sums = new SumClass[threads];
		for (int i = 0; i < threads; i++) {
			sums[i] = new SumClass(arr, i * size, (i + 1) * size);
			sums[i].start();
		}
		try {
			for (SumClass sum : sums) {
				sum.join();
			}
		} catch (InterruptedException e) {
		}
		int total = 0;
		for (SumClass sum : sums) { 
			total += sum.getPartialSum();
		}
		return total;
	}
}
