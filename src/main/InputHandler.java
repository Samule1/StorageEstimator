package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.UnsupportedCommandException;
import group.BasicGroup;
import group.Group;
import image.Image;
import parser.BitmapParser;
import parser.GroupParser;
import parser.JPG2Parser;
import parser.JPGParser;
import parser.LineParser;

public class InputHandler {
	
	private List<Group> groups;
	private Group unassigned;
	private Map<String, LineParser> parsers; 
	private int nextUnassignedMemberId = 1; 
	
	public InputHandler() {
	
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
	
	public void parse(List<String> input) {
		
		for(String line : input) {
			String[] lineComponents = line.split(" ");
			LineParser parser = parsers.get(lineComponents[0]);
			
			if(parser == null) {throw new UnsupportedCommandException(lineComponents[0]);}
			
			String[] arguments = Arrays.copyOfRange(lineComponents, 1, lineComponents.length);
			parser.parseAndExecute(arguments, this);
		}
		
	}
	
	public List<Group> getGroups(){
		return groups;
	}
	
	public void addGroup(Group group) {
		groups.add(group);
	}
	
	public int getNextUnassignedMemberId() {
		return nextUnassignedMemberId++;
	}
	
	public void addUnassigned(Image img, int id) {
		unassigned.addMember(img, id);
	}
	
	public Image deleteUnassigned(int id) {
		return unassigned.deleteMember(id);
	}
	
	public List<Image> getAllUnassigned(){
		return unassigned.getMembers();
	}
	
	public boolean isUnassigned(int id) {
		return unassigned.hasMember(id);
	}

}
