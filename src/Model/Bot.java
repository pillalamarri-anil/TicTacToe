package Model;

import Enums.PlayerType;
import Strategy.BotMoveStrategy.BotMoveStrategy;
import Enums.BotDifficultyLevel;
import Factory.BotMoveStrategyFactory;

public class Bot extends Player {

    private BotDifficultyLevel difficulty;
    private BotMoveStrategy moveStrategy;

    public Bot(String playerName, Symbol symbol, BotDifficultyLevel difficulty) {
        super(playerName, symbol, PlayerType.BOT);
        this.difficulty = difficulty;
        moveStrategy = BotMoveStrategyFactory.create(difficulty);
    }

    public BotDifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BotDifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public Cell chooseCellToPlay(Board board)
    {
        return moveStrategy.chooseCellToPlay(board);
    }

    @Override
    public boolean unDo()
    {
        return false;
    }
}
