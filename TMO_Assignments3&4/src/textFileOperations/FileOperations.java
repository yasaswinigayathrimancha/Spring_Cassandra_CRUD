package textFileOperations;

import java.io.*;

public class FileOperations {

	public static void main(String[] args) {

		String filename = "C:\\Users\\ygayathri\\Documents\\cassandra.txt";

		int wordCount = 0;
		int lineCount = 0;
		String longestWord = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lineCount++;
				String[] words = line.split("\\s+");
				for (String word : words) {
					wordCount++;
					if (word.length() > longestWord.length()) {
						longestWord = word;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error while reading the file" + e.getMessage());

		}

		System.out.println("Number of words in the file: " + wordCount);
		System.out.println("Number of lines in the file: " + lineCount);
		System.out.println("Longest word of the file is: " + longestWord);

	}

}
