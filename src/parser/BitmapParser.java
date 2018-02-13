package parser;
import exception.InvalidImageParameterException;
import image.BitmapImage;
import main.InputHandler;
/**
 * 
 * Input parser for uncompressed bitmap images.
 * 
 * @author Hampus Carlsson
 *
 */
public class BitmapParser implements LineParser {

	public void parseAndExecute(String[] args, InputHandler handler) {
		
		if(this.validate(args, handler)) {
			
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			BitmapImage img = new BitmapImage(width, height);
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
