package parser;
import exception.InvalidImageParameterException;
import image.BitmapImage;
import main.InputBlock;

public class BitmapParser implements LineParser {

	public void parseAndExecute(String[] args, InputBlock block) {
		
		if(this.validate(args, block)) {
			
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			BitmapImage img = new BitmapImage(width, height);
			block.addUnassigned(img, block.getNextUnassignedMemberId());
		}
		else {
			throw new InvalidImageParameterException(args);
		}
		
	}

	public boolean validate(String[] args, InputBlock block) {
			
		if(!(args.length == 2)) {return false;}
		
		try {
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			if(width < 1 || height < 1) {return false;}
		}
		catch(NumberFormatException e) {return false;}
		
		return true;
	}


}
