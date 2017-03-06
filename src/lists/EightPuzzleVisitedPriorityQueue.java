package lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

import tree.EightPuzzleNode;

public class EightPuzzleVisitedPriorityQueue implements EightPuzzleList {
	private PriorityQueue<EightPuzzleNode> priorityQueue;
	private HashSet<Integer> visited;

	public EightPuzzleVisitedPriorityQueue(
			Comparator<EightPuzzleNode> comparator) {
		priorityQueue = new PriorityQueue<EightPuzzleNode>(100, comparator);
		visited = new HashSet<Integer>();
	}

	@Override
	public void add(EightPuzzleNode node) {
		if (!visited.contains(Arrays.hashCode(node.getConfig())))
			priorityQueue.add(node);

	}

	@Override
	public EightPuzzleNode remove() {
		EightPuzzleNode node = priorityQueue.poll();
		visited.add(Arrays.hashCode(node.getConfig()));
		return node;
	}

	@Override
	public boolean isEmpty() {
		return priorityQueue.isEmpty();
	}

}
