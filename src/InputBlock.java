import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputBlock {
	
	private List<Image> images;
	private List<Group> groups;
	public Group unassigned;
	private Map<String, LineParser<?,?>> parsers; 
	private int nextUnassignedMemberId = 1; 
	
	public InputBlock() {
		
		this.images = new ArrayList<>();
		this.groups = new ArrayList<>();
		this.parsers = new HashMap<>();
		this.unassigned = new BasicGroup();
		
		parsers.put("JPG", new JPGParser());
		parsers.put("J", new JPGParser());
		parsers.put("G", new GroupParser());
		parsers.put("JP2", new JPG2Parser());
		parsers.put("JPEG2000", new JPG2Parser());
		parsers.put("BMP", new BitmapParser());
		
	}
	
	/* The parse method reads each line of the
	 * input and assigns every image to a group
	 */
	public void parse(List<String> input) {
		
		for(String line : input) {
			String[] lineComponents = line.split(" ");
			LineParser<?, ?> parser = parsers.get(lineComponents[0]);
			String[] arguments = Arrays.copyOfRange(lineComponents, 1, lineComponents.length);
			parser.parseAndExecute(arguments, this);
		}
		
	}
	
	public List<Group> getGroups(){
		return groups;
	}
	
	public Group getGroup(int groupNumber){
		return groups.get(groupNumber);
	}
	
	public void addGroup(Group group) {
		groups.add(group);
	}
	
	public Image getImage(int imageNumber) {
		return images.get(imageNumber);
	}
	
	public void addImage(Image img) {
		images.add(img);
	}
	
	
	public int getNextUnassignedMemberId() {
		return nextUnassignedMemberId++;
	}
	
	public void addUnassigned(Image img, int id) {
		unassigned.addMember(img, id);
	}
		
	

}
