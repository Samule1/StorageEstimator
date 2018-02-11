import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RunFromHere {
	
	public static void main(String [] args) {
		
		Scanner sysin = new Scanner(System.in);
		
		//PRINT HEADER.
		System.out.println("==========================================");
		System.out.println("*  Storage Estimator by Hampus Carlsson  *");
		System.out.println("==========================================");
		System.out.println();
		System.out.println("- Enter one image per row.");
		System.out.println("- Group images by enetering G i, i, ... , i \n  where i is an image index.");
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
		
		//Parse input
		InputBlock block = new InputBlock();
		block.parse(inputLines);

		StorageEvaluator eval = new StorageEvaluator();
		
		int result = eval.evaluate(block);
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	    String resultString = numberFormat.format(result);
	    System.out.println("Total size : "+resultString+" bytes");
		
		sysin.close();
	}

}
