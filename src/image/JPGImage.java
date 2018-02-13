package image;
/**
 * 
 * Image class for images of the type JPEG.
 * 
 * @author Hampus Carlsson
 *
 */
public class JPGImage extends Image {
	
	private JPGImage nextLevel = null;
	
	public JPGImage(int width, int height) {
		super(width, height);
		
		int levelWidth = (int) Math.floor(width/2);
		int levelHeight = (int) Math.floor(height/2);
		
		if(levelWidth >= 128 && levelHeight >= 128) {
			nextLevel = new JPGImage(levelWidth, levelHeight);
		}
		
	}

	@Override
	public int getCost() {
		
		if(this.nextLevel != null) {
			return (int)Math.floor(width * height * 0.2) + nextLevel.getCost();
		}
		else {
			return (int)Math.floor(width * height * 0.2);
		}
	}

}
