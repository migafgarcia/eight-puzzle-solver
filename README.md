# Eight Puzzle Solver

Eight Puzzle game solver implemented using various search algorithms:
- [Breadth first search](https://en.wikipedia.org/wiki/Breadth-first_search)
- [Depth first search](https://en.wikipedia.org/wiki/Depth-first_search)
- [Iterative depth first search](https://en.wikipedia.org/wiki/Iterative_deepening_depth-first_search)
- [Greedy](https://en.wikipedia.org/wiki/Greedy_algorithm)
- [A Star](https://en.wikipedia.org/wiki/A*_search_algorithm)

From an initial configuration, the program uses the selected algorithm to find a final configuration.

For Greedy and A Star, the heuristic used is the [Manhattan Distance](https://heuristicswiki.wikispaces.com/Manhattan+Distance) of the current configuration to the final one.



```
Initial Config:
3 4 2 
5 1 7 
6 0 8 

Using A Star Search
1 2 3 
8 0 4 
7 6 5 
Solution Depth: 23
Time: (aprox) 101.1 ms
Generated Nodes: 71875
```

## Usage
```
 $ java EightPuzzleSearch [-v] [-i INITIAL_CONFIG] [-f FINAL_CONFIG] [-a ALGORITHM]

-v                Verbose
-i INITIAL_CONFIG Initial config as a single number. Ex: -i 342517608
-f FINAL_CONFIG   Final config as a single number. Ex: -f 123804765
-a ALGORITHM      Which algorithm to use as a number from 0 to 4, using the order above. Ex using IDFS: -a 2

```
