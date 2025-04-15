package Controller;

import Exceptions.PlayerCountNotValidException;
import Exceptions.SymbolNotUniqueException;
import Model.Game;
import Model.Player;
import Strategy.GameWinStrategy.GameWinStrategy;

import java.util.List;

public class GameController {

   public Game startGame(int dimension, List<Player> players, List<GameWinStrategy> gameWinStrategyList)
            throws SymbolNotUniqueException, PlayerCountNotValidException {

        return Game.getBuilder().setDimension(dimension).setGameWinStrategy(gameWinStrategyList)
                .setPlayers(players).build();
    }

    public void makeMove(Game game)
    {
        game.makeMove();
    }

    public void unDo(Game game)
    {
        // return game.unDO();
    }
}
