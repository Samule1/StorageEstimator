
public class BitmapParser implements LineParser<BitmapImage, Boolean> {

	public BitmapImage parseAndExecute(String[] args, InputBlock block) {
		
		if(this.validate(args, block)) {
			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			
			BitmapImage img = new BitmapImage(width, height);
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
