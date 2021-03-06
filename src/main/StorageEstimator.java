package main;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import eval.StorageEvaluator;

/**
 * This is the class contains the main method. It prints the header
 * and scans stdin for user input in the form of lines. When the input
 * has been received and parsed it is evaluated and the result is printed
 * to stdout. 
 * 
 * @author Hampus Carlsson
 *
 */


public class StorageEstimator {
	
	public static void main(String [] args) {
		
		Scanner sysin = new Scanner(System.in);
		
		//PRINT HEADER.
		System.out.println("==========================================");
		System.out.println("*  Storage Estimator by Hampus Carlsson  *");
		System.out.println("==========================================");
		System.out.println();
		System.out.println("- Enter one image per row.");
		System.out.println("- Group images by entering G i, i, ... , i \n  where i is an image index.");
		System.out.println("- Enter q on a new line to evaluate input.");
		System.out.println();
		System.out.println("Enter your input below this line -->");	
		
		
		//Read input
		String input = sysin.nextLine();
		List<String> inputLines = new ArrayList<String>();
		
		while(!input.equals("q")) {
			inputLines.add(input);
			input = sysin.nextLine();
		}
		sysin.close();
		
		//Parse input
		InputHandler handler = new InputHandler();
		handler.parse(inputLines);

		StorageEvaluator eval = new StorageEvaluator();
		
		int result = eval.evaluate(handler);
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	    String resultString = numberFormat.format(result);
	    System.out.println("Total size : "+resultString+" bytes");
		
	}

}
