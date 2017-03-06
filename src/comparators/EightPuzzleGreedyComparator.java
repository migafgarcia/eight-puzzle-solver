package comparators;
import tree.EightPuzzleNode;

import java.util.Comparator;

public class EightPuzzleGreedyComparator implements Comparator<EightPuzzleNode> {

	@Override
	public int compare(EightPuzzleNode node0, EightPuzzleNode node1) {
		return node0.getGreedyNodeValue() - node1.getGreedyNodeValue();
	}

}
