package Factory;

import Strategy.BotMoveStrategy.BotMoveStrategy;
import Strategy.BotMoveStrategy.DiffucultBotMoveStrategy;
import Strategy.BotMoveStrategy.EasyBotMoveStrategy;
import Strategy.BotMoveStrategy.MediumBotMoveStrategy;
import Enums.BotDifficultyLevel;

public class BotMoveStrategyFactory {
    public static BotMoveStrategy create(BotDifficultyLevel difficultyLevel)
    {
        if(difficultyLevel.equals(BotDifficultyLevel.EASY))
            return new EasyBotMoveStrategy();
        else if (difficultyLevel.equals(BotDifficultyLevel.HARD))
            return new DiffucultBotMoveStrategy();
        else if (difficultyLevel.equals(BotDifficultyLevel.MEDIUM))
            return new MediumBotMoveStrategy();
        return null;
    }
}
