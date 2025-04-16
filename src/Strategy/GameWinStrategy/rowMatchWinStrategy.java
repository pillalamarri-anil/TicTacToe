package Strategy.GameWinStrategy;

import Model.Board;
import Model.Cell;
import Model.Move;
import Model.Player;

import java.util.HashMap;

public class rowMatchWinStrategy implements GameWinStrategy {

    private HashMap<Integer, HashMap<Player, Integer>> rowPlayerCount;

    public rowMatchWinStrategy()
    {
        rowPlayerCount = new HashMap();
    }

    @Override
    public boolean checkWin(Move move, Board board) {
        Player player = move.getPlayer();
        Cell cell = move.getCell();

        HashMap<Player, Integer> playerCount = (HashMap<Player, Integer>) rowPlayerCount.getOrDefault(cell.getRow(), new HashMap());
        playerCount.put(player, playerCount.getOrDefault(player, 0) + 1);
        rowPlayerCount.put(cell.getRow(), playerCount);

       if(playerCount.get(player) == board.getDimension())
           return true;

       return false;

    }

    @Override
    public void unDo(Move move, Board board) {
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        HashMap<Player, Integer> playerCount = rowPlayerCount.get(cell.getRow());
        playerCount.put(player, playerCount.get(player) - 1);
        rowPlayerCount.put(cell.getCol(), playerCount);
    }
}
