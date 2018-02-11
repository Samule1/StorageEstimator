package image;
public class JPG2Image extends Image{

	public JPG2Image(int width, int height) {
		super(width, height);
	}

	@Override
	public int getCost() {
		return (int)Math.floor((width*height*0.4)/Math.log(Math.log((width*height)+16)));
	}

}
