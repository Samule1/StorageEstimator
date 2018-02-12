package parser;
import exception.InvalidImageParameterException;
import image.JPG2Image;
import main.InputHandler;

public class JPG2Parser implements LineParser {
	
	public void parseAndExecute(String[] args, InputHandler handler) {
		
		if(this.validate(args, handler)) {
			
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			JPG2Image img = new JPG2Image(width, height);
			handler.addUnassigned(img, handler.getNextUnassignedMemberId());
		}
		else {
			throw new InvalidImageParameterException(args);
		}

	}

	public boolean validate(String[] args, InputHandler handler) {
		
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
