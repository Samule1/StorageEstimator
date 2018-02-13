package parser;

import exception.InvalidGroupException;
import group.BasicGroup;
import group.Group;
import main.InputHandler;
/**
 * 
 * Input parser for group command.
 * 
 * @author Hampus Carlsson
 *
 */
public class GroupParser implements LineParser{

	@Override
	public void parseAndExecute(String[] args, InputHandler handler) {
		
		if(this.validate(args, handler)) {
			
			Group group = new BasicGroup();
			
			for(String s : args) {
				int id = Integer.parseInt(s);
				group.addMember(handler.deleteUnassigned(id), id);
			}
			
			handler.addGroup(group);

		}
		else {
			throw new InvalidGroupException(args);
		}	
	}

	@Override
	public boolean validate(String[] args, InputHandler handler) {
		
		if(args.length < 2) {return false;}
		
		for(String arg : args) {
			
			try {
				int id = Integer.parseInt(arg);
				if(!handler.isUnassigned(id)) {return false;}
			}
			
			catch(NumberFormatException e) {return false;}
		}
		
		return true;	
	}
	
}
