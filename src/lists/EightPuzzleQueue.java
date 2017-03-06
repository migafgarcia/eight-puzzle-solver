package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import tree.EightPuzzleNode;

public class EightPuzzleQueue implements EightPuzzleList {
	private ArrayList<EightPuzzleNode> queue;
	private HashSet<Integer> visited;

	public EightPuzzleQueue() {
		queue = new ArrayList<EightPuzzleNode>();
		visited = new HashSet<Integer>();
	}

	@Override
	public void add(EightPuzzleNode node) {
		if (!visited.contains(Arrays.hashCode(node.getConfig())))
			queue.add(node);

	}

	@Override
	public EightPuzzleNode remove() {
		EightPuzzleNode node = queue.remove(0);
		visited.add(Arrays.hashCode(node.getConfig()));
		return node;
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
