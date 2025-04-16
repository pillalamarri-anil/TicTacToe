package Model;

import Enums.PlayerType;

import java.util.Scanner;

public class Player {
    private String playerName;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);

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

    public Cell chooseCellToPlay(Board board)
    {
        System.out.println(getPlayerName() + " make move");
        System.out.println("Enter row:");
        int row = scanner.nextInt();

        System.out.println("Enter col:");
        int col = scanner.nextInt();

        return new Cell(row, col);
    }

    public boolean unDo()
    {
        System.out.println("Do you want to unDo? (Y/N)");
        char answer = scanner.next().charAt(0);
        if(answer == 'Y')
            return true;
        return false;
    }

    public Symbol getPlayerSymbol() {
        return symbol;
    }

}
