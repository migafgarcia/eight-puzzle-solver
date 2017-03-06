package tree;
import java.util.Arrays;

public class EightPuzzleNode {
	private final byte currentConfig[];
	private static int generatedNodes = 0;
	private final int DEPTH;
	private int heuristic;
	private static byte REVERSE_FINAL_CONFIG[];
	private static byte FINAL_CONFIG[];
	private final EightPuzzleNode parent;


	
	public EightPuzzleNode(byte config[], EightPuzzleNode parent, int depth) {
		currentConfig = Arrays.copyOf(config, config.length);
		this.DEPTH = depth;
		this.parent = parent;
		generateHeuristic();
		generatedNodes++;
	}
	
	public byte[] getConfig() {
		return currentConfig;
	}

	public int getGreedyNodeValue() {
		return heuristic;
	}

	public int getAStarNodeValue() {
		return DEPTH + heuristic;
	}

	public byte[] getCurrentConfig() {
		return currentConfig;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public int getDepth() {
		return DEPTH;
	}

	public int getNumNodes() {
		return generatedNodes;
	}

	public EightPuzzleNode getParent() {
		return parent;
	}

	public boolean isFinal() {
		return Arrays.equals(currentConfig, FINAL_CONFIG);
	}

	public void generateHeuristic() {
		byte x, y;
		heuristic = 0;
		for (byte i = 0; i < 9; i++) {
			x = (byte) Math.abs(i % 3 - REVERSE_FINAL_CONFIG[currentConfig[i]] % 3);
			y = (byte) Math.abs(i / 3 - REVERSE_FINAL_CONFIG[currentConfig[i]] / 3);
			heuristic += x + y;
		}
	}

	public static void setFinalConfig(byte[] finalConfig) {
		FINAL_CONFIG = Arrays.copyOf(finalConfig, finalConfig.length);
		REVERSE_FINAL_CONFIG = new byte[FINAL_CONFIG.length];
		for(byte i = 0; i < FINAL_CONFIG.length; i++) {
			REVERSE_FINAL_CONFIG[FINAL_CONFIG[i]] = i;
		}

	}
	
	public boolean solvable() {
		int permutations = 0;
		for (int i = 0; i < 9; i++)
			if (currentConfig[i] != 0)
				for (int j = i + 1; j < 9; j++)
					if (currentConfig[j] != 0
							&& REVERSE_FINAL_CONFIG[currentConfig[i]] > REVERSE_FINAL_CONFIG[currentConfig[j]])
						permutations++;
		return (permutations % 2 == 0);

	}

	public byte[] swapUp() {
		byte config[] = Arrays.copyOf(currentConfig, currentConfig.length);
		for (byte i = 0; i < config.length; i++) {
			if (config[i] == 0 && i != 0 && i != 1 && i != 2) {
				config[i] = config[i - 3];
				config[i - 3] = 0;
				return config;
			}
		}
		return null;
	}

	public byte[] swapRight() {
		byte config[] = Arrays.copyOf(currentConfig, currentConfig.length);
	
		for (byte i = 0; i < config.length; i++) {
			if (config[i] == 0 && i != 2 && i != 5 && i != 8) {
				config[i] = config[i + 1];
				config[i + 1] = 0;
				return config;
			}
		}
		return null;
	}

	public byte[] swapDown() {
		byte config[] = Arrays.copyOf(currentConfig, currentConfig.length);

		for (byte i = 0; i < config.length; i++) {
			if (config[i] == 0 && i != 6 && i != 7 && i != 8) {
				config[i] = config[i + 3];
				config[i + 3] = 0;
				return config;
			}
		}
		return null;
	}

	public byte[] swapLeft() {
		byte config[] = Arrays.copyOf(currentConfig, currentConfig.length);

		for (byte i = 0; i < config.length; i++) {
			if (config[i] == 0 && i != 0 && i != 3 && i != 6) {
				config[i] = config[i - 1];
				config[i - 1] = 0;
				return config;
			}
		}
		return null;
	}

	public String toString() {
		String str = new String();
		for (byte i = 0; i < 9; i++) {
			str += currentConfig[i] + " ";
			if (i == 2 || i == 5 || i == 8)
				str += "\n";
		}
		return str;
	}

}
