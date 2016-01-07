package businesslogic;

import java.security.InvalidParameterException;

import interfaces.IGameOfLife;

public class GameOfLife implements IGameOfLife {

	private int[][] currentState;

	@Override
	public void seed(int[][] pattern) {
		currentState = pattern;
	}

	@Override
	public int[][] next() {
		// Two dimensional array with all its elements initialized at zero by
		// default
		int[][] nextState = new int[currentState.length][currentState.length];

		for (int row = 0; row < currentState.length; row++) {
			for (int col = 0; col < currentState[row].length; col++) {
				int currentCell = currentState[row][col];
				int neighbourSum = 0;

				for (int x = row - 1; x <= row + 1; x++) {
					for (int y = col - 1; y <= col + 1; y++) {
						if (x == row && y == col) {
						} else {
							try {
								neighbourSum += currentState[x][y];
							} catch (ArrayIndexOutOfBoundsException e) {
							}
						}
					}
				}

				if (currentCell == 1) {
					if (neighbourSum < 2 || neighbourSum > 3) {
						nextState[row][col] = 0;
					} else if (neighbourSum == 2 || neighbourSum == 3) {
						nextState[row][col] = 1;
					}
				} else if (currentCell == 0) {
					if (neighbourSum == 3) {
						nextState[row][col] = 1;
					}
				} else {
					throw new InvalidParameterException("Invalid cell value");
				}
			}
		}

		currentState = nextState;
		return currentState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int row = 0; row < currentState.length; row++) {
			builder.append("[");
			for (int col = 0; col < currentState[row].length; col++) {
				String j = ((col == currentState[row].length - 1) ? "" : ",\t");
				builder.append(currentState[row][col] + j);
			}
			String m = ((row == currentState.length - 1) ? "]\n" : "],\n");

			builder.append(m);
		}
		return builder.toString();
	}

}
