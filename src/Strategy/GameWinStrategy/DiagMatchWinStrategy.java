package Strategy.GameWinStrategy;

import Model.Board;
import Model.Cell;
import Model.Player;
import Model.Move;

import java.util.HashMap;

public class DiagMatchWinStrategy implements GameWinStrategy {

    private HashMap<Player, Integer> primaryDiagCount;
    private HashMap<Player, Integer> secondaryDiagCount;

    public DiagMatchWinStrategy()
    {
        primaryDiagCount = new HashMap<>();
        secondaryDiagCount = new HashMap<>();
    }

    @Override
    public boolean checkWin(Move move, Board board) {

        Cell cell = move.getCell();
        Player player = move.getPlayer();

        if(cell.getRow() == cell.getCol())
        {
            primaryDiagCount.put( player, primaryDiagCount.getOrDefault( player, 0) + 1);

            if(primaryDiagCount.get( player ) == board.getDimension())
                return true;
        }

        if(cell.getRow() == board.getDimension() - 1 - cell.getCol())
        {
            secondaryDiagCount.put( player, secondaryDiagCount.getOrDefault( player, 0) + 1);

            if(secondaryDiagCount.get( player ) == board.getDimension())
                return true;
        }
        return false;
    }

    @Override
    public void unDo(Move move, Board board) {

        Cell cell = move.getCell();
        Player player = move.getPlayer();

        if(cell.getRow() == cell.getCol())
            primaryDiagCount.put( player, primaryDiagCount.get( player) - 1);

        if(cell.getRow() == board.getDimension() - 1 - cell.getCol())
            secondaryDiagCount.put( player, secondaryDiagCount.get( player) - 1);


    }
}
