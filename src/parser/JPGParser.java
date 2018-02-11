package parser;
import exception.InvalidImageParameterException;
import image.JPGImage;
import main.InputBlock;

public class JPGParser implements LineParser<Boolean> {

	public void parseAndExecute(String[] args, InputBlock block) {
		
		if(this.validate(args, block)) {
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			JPGImage img = new JPGImage(width, height);
			block.addImage(img);
			
			block.addUnassigned(img, block.getNextUnassignedMemberId());
		}
		else {
			throw new InvalidImageParameterException(args);
		}
		
		
		
	}

	public Boolean validate(String[] args, InputBlock block) {
		
		if(!(args.length == 2)) {
			return false;
		}
		
		try {
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			if(width < 1 || height < 1) {
				return false;
			}
		}
		catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}

}
