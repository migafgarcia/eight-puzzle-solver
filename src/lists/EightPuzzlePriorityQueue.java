package lists;

import java.util.Comparator;
import java.util.PriorityQueue;

import tree.EightPuzzleNode;

public class EightPuzzlePriorityQueue implements EightPuzzleList {
	private PriorityQueue<EightPuzzleNode> priorityQueue;

	public EightPuzzlePriorityQueue(Comparator<EightPuzzleNode> comparator) {
		priorityQueue = new PriorityQueue<EightPuzzleNode>(100, comparator);
	}

	@Override
	public void add(EightPuzzleNode node) {
		priorityQueue.add(node);

	}

	@Override
	public EightPuzzleNode remove() {
		return priorityQueue.poll();
	}

	@Override
	public boolean isEmpty() {
		return priorityQueue.isEmpty();
	}

}
