package Strategy.BotMoveStrategy;

import Enums.CellState;
import Model.Board;
import Model.Cell;
import Model.Move;

public class DiffucultBotMoveStrategy implements BotMoveStrategy {

    @Override
    public Cell chooseCellToPlay(Board board)
    {
        for(int i = 0; i < board.getDimension(); i++){
            for(int j = 0; j < board.getDimension(); j++) {
                Cell cell = board.getCell(i, j);
                if(cell.getState() == CellState.EMPTY)
                    return cell;
            }
        }
        return null;
    }
}
