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

    @Override
    public Move makeMove(int row, int col) {
        return moveStrategy.move();
    }

    public BotDifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BotDifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }
}
