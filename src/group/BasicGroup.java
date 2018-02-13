package group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import image.Image;

/**
 * A class that implements the group interface. Used for grouping
 * of images.
 * 
 * @author Hampus Carlsson
 *
 */
public class BasicGroup implements Group{
	
	private Map<Integer, Image> members;
	
	public BasicGroup() {
		members = new HashMap<>();

	}
	
	public boolean hasMember(int id) {
		return members.containsKey(id);
	}
	
	public void addMember(Image img, int id) {
		members.put(id, img);
		
	}
	
	public List<Image> getMembers(){
		return new ArrayList<Image>(members.values());
	}

	@Override
	public Image getMember(int id) {
		// TODO Auto-generated method stub
		return members.get(id);
	}

	@Override
	public Image deleteMember(int id) {
		return members.remove(id);
	}


}
