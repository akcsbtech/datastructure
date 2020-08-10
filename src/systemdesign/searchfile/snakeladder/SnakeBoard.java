package systemdesign.searchfile.snakeladder;

import java.util.List;

public class SnakeBoard implements Board {
	List<Snake> snakes;
	List<Ladder> ladders;
	List<SnakeGamePlayer> players;
	Cell[][] cells;
	SixFaceDice dice = SixFaceDice.getSixFaceDice();

	SnakeBoard() {
		// initialize snakes, ladder, cells & players
	}

	SnakeBoard(List<SnakeGamePlayer> snakes, List<Ladder> ladders, List<Player> players, int row, int column) {
		// assign member vars
		this.cells = new Cell[row][column];
	}

	boolean winner() {
		// return null until no one won the game
	}

	public void reset() {
	}

	public void bite() {
		// if new position of player is same as anyone of the snake head pos, update
		// player position
	}

	public void moveUpTheLadder() {
	}
}