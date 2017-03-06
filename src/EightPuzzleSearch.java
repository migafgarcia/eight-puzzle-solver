import lists.EightPuzzleIteratedStack;
import lists.EightPuzzleList;
import lists.EightPuzzlePriorityQueue;
import lists.EightPuzzleQueue;
import lists.EightPuzzleStack;
import lists.EightPuzzleVisitedPriorityQueue;
import comparators.EightPuzzleAStarComparator;
import comparators.EightPuzzleGreedyComparator;
import tree.EightPuzzleNode;

public class EightPuzzleSearch {
	static boolean VERBOSE = false;

	public static void log(String str) {
		if (VERBOSE)
			System.out.println(str);
	}

	public static void main(String[] args) {
		byte[] initialConfig = new byte[] { 3, 4, 2, 5, 1, 7, 6, 0, 8 };
		byte[] finalConfig = new byte[] { 1, 2, 3, 8, 0, 4, 7, 6, 5 };
		int algorithm = 4;

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-v"))
				VERBOSE = true;
			else if (args[i].equals("-i")) {
				i++;
				if (args[i] == null)
					return;
				initialConfig = parseConfig(args[i]);
			} else if (args[i].equals("-f")) {
				i++;
				if (args[i] == null)
					return;
				finalConfig = parseConfig(args[i]);
			} else if (args[i].equals("-a")) {
				i++;
				if (args[i] == null)
					return;
				algorithm = Integer.parseInt(args[i]);

			}

		}


		EightPuzzleNode.setFinalConfig(finalConfig);
		EightPuzzleNode initialNode = new EightPuzzleNode(initialConfig, null, 0);
		System.out.println("Initial Config:\n" + initialNode.toString());

		if (!initialNode.solvable()) {
			System.out.println("Not solvable");
			return;
		}

		EightPuzzleNode result = null;
		long time = System.nanoTime();

		switch (algorithm) {
		case 0: // BFS
			System.out.println("Using Breadth First Search");
			result = multiAlgorithmSearch(initialNode, new EightPuzzleQueue());
			break;
		case 1: // DFS
			System.out.println("Using Depth First Search");
			result = multiAlgorithmSearch(initialNode, new EightPuzzleStack());
			break;
		case 2: // IDFS
			System.out.println("Using Iterative Depth First Search");
			result = multiAlgorithmSearch(initialNode, new EightPuzzleIteratedStack());
			break;
		case 3: // Greedy
			System.out.println("Using Greedy Search");
			result = multiAlgorithmSearch(initialNode, new EightPuzzleVisitedPriorityQueue(
					new EightPuzzleGreedyComparator()));
			break;
		case 4: // A*
			System.out.println("Using A Star Search");
			result = multiAlgorithmSearch(initialNode, new EightPuzzlePriorityQueue(
					new EightPuzzleAStarComparator()));
			break;
		default:
			System.out.println("");
			return;
		}
		if (result == null) {
			System.out.println("Not solvable\n");
			// return;
		} else {
			time = System.nanoTime() - time;
			System.out.printf(result.toString()
					+ "Solution Depth: %d\nTime: (aprox) %.1f ms\nGenerated Nodes: %d\n\n",
					result.getDepth(), (time * Math.pow(10, -6)), result.getNumNodes());
		}

	}

	public static byte[] parseConfig(String config) {
		byte[] configGrid = new byte[9];
		for (int i = 0; i < 9; i++) {
			configGrid[i] = (byte) Character.getNumericValue(config.charAt(i));
		}
		return configGrid;
	}

	public static EightPuzzleNode multiAlgorithmSearch(EightPuzzleNode root, EightPuzzleList list) {
		if (!root.solvable())
			return null;
		list.add(root);

		while (!list.isEmpty()) {
			EightPuzzleNode current = list.remove();
			log("Depth: " + current.getDepth() + " Heuristic:" + current.getHeuristic());
			if (current.isFinal())
				return current;

			byte[] childConfig;

			childConfig = current.swapUp();

			if (childConfig != null)
				list.add(new EightPuzzleNode(childConfig, current, current.getDepth() + 1));

			childConfig = current.swapRight();

			if (childConfig != null)
				list.add(new EightPuzzleNode(childConfig, current, current.getDepth() + 1));

			childConfig = current.swapDown();

			if (childConfig != null)
				list.add(new EightPuzzleNode(childConfig, current, current.getDepth() + 1));

			childConfig = current.swapLeft();

			if (childConfig != null)
				list.add(new EightPuzzleNode(childConfig, current, current.getDepth() + 1));

		}

		return null;
	}

}
