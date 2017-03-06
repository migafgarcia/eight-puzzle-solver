package lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import tree.EightPuzzleNode;


public class EightPuzzleStack implements EightPuzzleList {
	private ArrayList<EightPuzzleNode> stack;
	private HashSet<Integer> visited;
	
	public EightPuzzleStack() {
		stack = new ArrayList<EightPuzzleNode>();
		visited = new HashSet<Integer>();
	}
	
	@Override
	public void add(EightPuzzleNode node) {
		if(!visited.contains(Arrays.hashCode(node.getConfig())))
		stack.add(0, node);
		
	}

	@Override
	public EightPuzzleNode remove() {
		EightPuzzleNode node = stack.remove(0);
		visited.add(Arrays.hashCode(node.getConfig()));
		return node;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
