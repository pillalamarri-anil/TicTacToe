package Model;

import Enums.PlayerType;

public class Player {
    private String playerName;
    private Symbol symbol;
    private PlayerType playerType;

    public Move makeMove(int row, int col)
    {
        return new Move(this, new Cell(row, col));
    }

    public Player(String playerName, Symbol symbol, PlayerType playerType) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Symbol getPlayerSymbol() {
        return symbol;
    }

}
