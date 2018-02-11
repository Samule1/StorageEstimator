package eval;
import java.util.List;

import group.Group;
import image.Image;
import main.InputBlock;

public class StorageEvaluator implements BlockEvaluator<Integer> {

	@Override
	public Integer evaluate(InputBlock block) {
		int costOfNonMemebers = 0;
		int costOfMembers = 0;
		
		List<Image> nonMembers = block.unassigned.getMembers();
		for(Image img : nonMembers) {
			costOfNonMemebers += img.getCost();
		}
		
		List<Group> imageGroups = block.getGroups();
		for(Group group : imageGroups) {
			
			List<Image> members = group.getMembers();
			int groupTotal = 0;
			
			for(Image img : members) {
				groupTotal += img.getCost();
			}
			
			costOfMembers += groupTotal / Math.log(members.size() + 3);
			
			
		}
		
		
		return costOfMembers + costOfNonMemebers;
	}

}
