package Model;

import Enums.CellState;
import Enums.GameState;
import Enums.GameWinStrategyType;
import Enums.PlayerType;
import Exceptions.PlayerCountNotValidException;
import Exceptions.SymbolNotUniqueException;
import Strategy.GameWinStrategy.GameWinStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private List<GameWinStrategy> gameWinStrategies;
    private Player winner;
    private GameState gameState;
    private Scanner scanner = new Scanner(System.in);
    private List<Move> moves;

    private Game(int dimension, List<Player> players, List<GameWinStrategy> gameWinStrategies)
    {
        this.board = new Board(dimension);
        this.players = players;
        this.gameWinStrategies = gameWinStrategies;
        currentPlayerIndex = 0;
        winner = null;
        gameState = GameState.IN_PROGRESS;
        moves = new ArrayList<Move>();
    }

    public void printBoard() {
        board.printBoard();
    }

    private boolean validateMove(int row, int col)
    {
        if(row < 0  || row >= board.dimension || col < 0  || col >= board.dimension) {
            System.out.println("Invalid move");
            return false;
        }
        if(board.cells.get(row).get(col).getState() != CellState.EMPTY)
        {
            System.out.println("Cell already occupied!");
            return false;
        }
        return true;
    }

   private boolean checkWin(Move move)
    {
        for(GameWinStrategy strategy : gameWinStrategies)
        {
            boolean isWin = strategy.checkWin(move, board);
            if(isWin)
                return true;
        }

        // draw case
        return moves.size() == board.dimension * board.dimension;
    }

    public void makeMove()
    {
        System.out.println(players.get(currentPlayerIndex).getPlayerName() + " make move");
        System.out.println("Enter row:");
        int row = scanner.nextInt();

        System.out.println("Enter col:");
        int col = scanner.nextInt();

        // validate move
        if(!validateMove(row, col))
            return;

        // make move
        Move move = players.get(currentPlayerIndex).makeMove(row, col);
        board.cells.get(row).get(col).setState(CellState.FILLED);
        board.cells.get(row).get(col).setPlayer(players.get(currentPlayerIndex));
        moves.add(move);

        // check win
        if(checkWin(move))
        {
            gameState = GameState.COMPLETE;
            winner = players.get(currentPlayerIndex);
            return;
        }

        // update next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private int dimension;
        private List<Player> players;
        private List<GameWinStrategy> gameWinStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameWinStrategy(List<GameWinStrategy> gameWinStrategies)
        {
            this.gameWinStrategies = gameWinStrategies;
            return this;
        }

        public void validatePlayerCount() throws PlayerCountNotValidException {
            if(players.size() >= dimension || players.size() < 2)
                throw new PlayerCountNotValidException("Player Count Not Valid");
        }

        private   void validateBoard()
        {
            if(dimension < 2)
                throw new IllegalArgumentException("Board Dimension Not Valid");
        }

        private  void validatePlayers()
        {
            boolean isHumanPlayer = false;
            for(Player player : players) {
                if (player.getPlayerType() == PlayerType.HUMAN)
                    isHumanPlayer = true;
            }
            if (!isHumanPlayer)
                throw new IllegalArgumentException("Atleast one Human player is required");
        }

        private void validateUniqueSymbol() throws SymbolNotUniqueException {
            HashSet<Symbol> symbols = new HashSet<>();
            for(Player player : players)
                symbols.add(player.getPlayerSymbol());

            if(symbols.size() != players.size())
                throw new SymbolNotUniqueException("Player Count Not Unique");
        }

        public Game build() throws PlayerCountNotValidException, SymbolNotUniqueException {

            validatePlayerCount();
            validateUniqueSymbol();
            validateBoard();

            return new Game(dimension, players, gameWinStrategies);
        }
    }

}
