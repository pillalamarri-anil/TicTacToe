package Strategy.BotMoveStrategy;

import Model.Board;
import Model.Cell;
import Model.Move;

public interface BotMoveStrategy {

    Cell chooseCellToPlay(Board board);
}
