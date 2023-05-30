package multithreading;

import java.util.Random;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		AverageOfNumbers averageOfNumbers = new AverageOfNumbers(randomNumberGenerator);

		Thread generatorThread = new Thread(randomNumberGenerator);
		Thread calculatorThread = new Thread(averageOfNumbers);

		generatorThread.start();
		generatorThread.join();
		calculatorThread.start();

	}
}



