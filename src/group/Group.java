package group;
import java.util.List;

import image.Image;

public interface Group {

	public boolean hasMember(int id);
	
	public void addMember(Image img, int id);
	
	public List<Image> getMembers();
	
	public Image getMember(int id);
	
	public Image deleteMember(int id);
	
}
