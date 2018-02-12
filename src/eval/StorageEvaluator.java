package eval;
import java.util.List;

import group.Group;
import image.Image;
import main.InputHandler;

public class StorageEvaluator implements BlockEvaluator<Integer> {

	@Override
	public Integer evaluate(InputHandler handler) {
		
		int costOfNonMemebers = 0;
		int costOfMembers = 0;
		
		List<Image> nonMembers = handler.getAllUnassigned();
		for(Image img : nonMembers) {
			costOfNonMemebers += img.getCost();
		}
		
		List<Group> imageGroups = handler.getGroups();
		
		for(Group group : imageGroups) {
			
			List<Image> members = group.getMembers();
			int groupTotal = 0;
			
			for(Image img : members) {
				groupTotal += img.getCost();
			}
			
			costOfMembers += Math.floor(groupTotal / Math.log(members.size() + 3));			
		}
			
		return costOfMembers + costOfNonMemebers;
	}

}
