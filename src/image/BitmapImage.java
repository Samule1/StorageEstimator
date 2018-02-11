package image;
public class BitmapImage extends Image {
	
	private BitmapImage nextLevel = null;
	
	public BitmapImage(int width, int height) {
		super(width, height);	
		
		int levelWidth = (int) Math.floor(width/2);
		int levelHeight = (int) Math.floor(height/2);
		
		if(levelWidth >= 128 && levelHeight >= 128) {
			nextLevel = new BitmapImage(levelWidth, levelHeight);
		}
	}

	@Override
	public int getCost() {
		
		if(nextLevel != null) {
			return (width*height) + nextLevel.getCost();
		}
		return width*height;
	}

}
