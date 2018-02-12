package parser;

import exception.InvalidGroupException;
import group.BasicGroup;
import group.Group;
import main.InputBlock;

public class GroupParser implements LineParser{

	@Override
	public void parseAndExecute(String[] args, InputBlock block) {
		
		if(this.validate(args, block)) {
			
			Group group = new BasicGroup();
			
			for(String s : args) {
				int id = Integer.parseInt(s);
				group.addMember(block.deleteUnassigned(id), id);
			}
			
			block.addGroup(group);

		}
		else {
			throw new InvalidGroupException(args);
		}	
	}

	@Override
	public boolean validate(String[] args, InputBlock block) {
		
		if(args.length < 2) {return false;}
		
		for(String arg : args) {
			
			try {
				int id = Integer.parseInt(arg);
				if(!block.isUnassigned(id)) {return false;}
			}
			
			catch(NumberFormatException e) {return false;}
		}
		
		return true;	
	}
	
}
