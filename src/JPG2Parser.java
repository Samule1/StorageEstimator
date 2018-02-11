
public class JPG2Parser implements LineParser<JPG2Image, Boolean> {
	
	public JPG2Image parseAndExecute(String[] args, InputBlock block) {
		
		if(this.validate(args, block)) {
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			JPG2Image img = new JPG2Image(width, height);
			block.addImage(img);
			
			block.addUnassigned(img, block.getNextUnassignedMemberId());
		}
		
		return null;
		
		
	}

	public Boolean validate(String[] args, InputBlock block) {
		
		if(!(args.length == 2)) {
			return false;
		}
		
		try {
			Integer.parseInt(args[0]);
			Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
}
