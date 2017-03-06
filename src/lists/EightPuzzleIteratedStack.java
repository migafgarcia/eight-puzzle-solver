package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import tree.EightPuzzleNode;

public class EightPuzzleIteratedStack implements EightPuzzleList {
	private ArrayList<EightPuzzleNode> stack;
	private HashSet<Integer> visited;
	private int maxDepth;

	public EightPuzzleIteratedStack() {
		maxDepth = 0;		
		stack = new ArrayList<EightPuzzleNode>();
		visited = new HashSet<Integer>();
	}
	
	@Override
	public void add(EightPuzzleNode node) {
		if(visited.contains(Arrays.hashCode(node.getConfig())))
			return;
		
		if (node.getDepth() <= maxDepth)
			stack.add(0, node);
		else
			stack.add(node);
	}

	@Override
	public EightPuzzleNode remove() {
		EightPuzzleNode node = stack.remove(0);
		visited.add(Arrays.hashCode(node.getConfig()));
		maxDepth = node.getDepth();
		return node;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
