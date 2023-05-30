package multithreading;

import java.util.Random;

class RandomNumberGenerator implements Runnable {

	private int[] arrayOfNumbers;
	private Random random;

	public RandomNumberGenerator() {
		arrayOfNumbers = new int[10];
		random = new Random();
	}

	@Override
	public void run() {
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfNumbers[i] = random.nextInt(350);
			System.out.println("Generated number: " + arrayOfNumbers[i]);
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int[] generatedNumbers() {
		return arrayOfNumbers;
	}

}
