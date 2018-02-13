package image;

/**
 * 
 * The abstract image class which is to be extended by all
 * concrete image types.
 * 
 * @author Hampus Carlsson
 *
 */

public abstract class Image {
	protected int width;
	protected int height;
	
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public abstract int getCost();
}
