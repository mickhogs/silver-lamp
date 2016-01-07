package interfaces;

/*
 * A game of life. A zero player game determined by the initial * state of
 * the integer array
 */
public interface IGameOfLife {

	/*
	 * set the initial state
	 */
	public void seed(int[][] pattern);

	/*
	 * Output the next state in the sequence
	 */
	public int[][] next();
}
