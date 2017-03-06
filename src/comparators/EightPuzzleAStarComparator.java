package comparators;
import tree.EightPuzzleNode;

import java.util.Comparator;


public class EightPuzzleAStarComparator implements Comparator<EightPuzzleNode> {

	@Override
	public int compare(EightPuzzleNode node0, EightPuzzleNode node1) {
		return (node0.getDepth() + node0.getHeuristic()) - (node1.getDepth() + node1.getHeuristic());
	}

}
