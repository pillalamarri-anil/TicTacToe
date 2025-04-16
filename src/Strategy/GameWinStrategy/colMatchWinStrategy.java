package Strategy.GameWinStrategy;

import Model.Board;
import Model.Cell;
import Model.Move;
import Model.Player;

import java.util.HashMap;

public class colMatchWinStrategy implements GameWinStrategy {

    private HashMap<Integer, HashMap<Player, Integer>> colPlayerCount;

    public colMatchWinStrategy()
    {
        colPlayerCount = new HashMap<>();
    }

    @Override
    public boolean checkWin(Move move, Board board) {

        Player player = move.getPlayer();
        Cell cell = move.getCell();

        HashMap<Player, Integer> playerCount = (HashMap<Player, Integer>) colPlayerCount.getOrDefault(cell.getCol(), new HashMap());
        playerCount.put(player, playerCount.getOrDefault(player, 0) + 1);
        colPlayerCount.put(cell.getCol(), playerCount);

        if(playerCount.get(player) == board.getDimension())
            return true;

        return false;
    }

    @Override
    public void unDo(Move move, Board board) {
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        HashMap<Player, Integer> playerCount = colPlayerCount.get(cell.getCol());
        playerCount.put(player, playerCount.get(player) - 1);
        colPlayerCount.put(cell.getCol(), playerCount);
    }


}
