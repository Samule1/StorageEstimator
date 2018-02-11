

public class GroupParser implements LineParser<Boolean, Boolean> {

	@Override
	public Boolean parseAndExecute(String[] args, InputBlock block) {
		
		if(this.validate(args, block)) {
			Group group = new BasicGroup();
			
			for(String s : args) {
				int id = Integer.parseInt(s);
				group.addMember(block.unassigned.deleteMember(id), id);
			}
			
			block.addGroup(group);
			return true;
		}
		
		return false;
		
		
		
		
	}

	@Override
	public Boolean validate(String[] args, InputBlock block) {
		
		for(String arg : args) {
			try {
				int id = Integer.parseInt(arg);
				
				if(!block.unassigned.hasMember(id)) {
					return false;
				}
			}
			catch(NumberFormatException e) {
				return false;
			}
		}
		
		return true;
		
	}

}
