package image;


public abstract class Image {
	protected int width;
	protected int height;
	
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public abstract int getCost();
}
