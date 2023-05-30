package multithreading;


class AverageOfNumbers implements Runnable {
	
	private RandomNumberGenerator randomNumberGenerator;

	public AverageOfNumbers(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int[] numbers = randomNumberGenerator.getNumbers();
		int sum = 0;
		for (int number : numbers) {
			sum = sum + number;
		}

		double average = (double) sum / numbers.length;
		System.out.println("Average of the numbers which are generated randomly: " + average);

	}

}
