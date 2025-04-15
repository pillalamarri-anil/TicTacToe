import Controller.GameController;
import Enums.GameState;
import Enums.GameWinStrategyType;
import Enums.PlayerType;
import Exceptions.PlayerCountNotValidException;
import Exceptions.SymbolNotUniqueException;
import Factory.GameWinStrategyFactory;
import Model.Game;
import Model.Player;
import Model.Symbol;
import Strategy.GameWinStrategy.GameWinStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.GameController;

public class Main {
    public static void main(String[] args) throws SymbolNotUniqueException, PlayerCountNotValidException {


        Player player1 = new Player("Anil", new Symbol('A', ""), PlayerType.HUMAN);
        Player player2 = new Player("Sunil", new Symbol('S', ""), PlayerType.HUMAN);


        GameWinStrategy strategy1 = GameWinStrategyFactory.create(GameWinStrategyType.ROW_MATCH);
        GameWinStrategy strategy2 = GameWinStrategyFactory.create(GameWinStrategyType.COLUMN_MATCH);
        GameWinStrategy strategy3 = GameWinStrategyFactory.create(GameWinStrategyType.DIAGONAL_MATCH);

        GameController gameController = new GameController();

        List<Player> players = List.of(player1, player2);
        List<GameWinStrategy> strategyList = List.of(strategy1, strategy2, strategy3);

        Game game = gameController.startGame(3, players, strategyList);

        while(game.getGameState() == GameState.IN_PROGRESS)
        {
            game.printBoard();
           game.makeMove();
        }

        game.printBoard();

        if(game.getWinner() != null)
            System.out.println(game.getWinner().getPlayerName() + " won the game");
        else
            System.out.println("Game is draw");
    }
}