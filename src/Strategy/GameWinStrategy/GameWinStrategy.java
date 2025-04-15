package Strategy.GameWinStrategy;

import Model.Board;
import Model.Move;

public interface GameWinStrategy {

    boolean checkWin(Move move, Board board);
}
