package Factory;

import Enums.GameWinStrategyType;
import Strategy.GameWinStrategy.DiagMatchWinStrategy;
import Strategy.GameWinStrategy.GameWinStrategy;
import Strategy.GameWinStrategy.colMatchWinStrategy;
import Strategy.GameWinStrategy.rowMatchWinStrategy;

public class GameWinStrategyFactory {
    public static GameWinStrategy create(GameWinStrategyType type)
    {
        if(type == GameWinStrategyType.ROW_MATCH)
            return new rowMatchWinStrategy();
        else if(type == GameWinStrategyType.DIAGONAL_MATCH)
            return new DiagMatchWinStrategy();
        else if(type == GameWinStrategyType.COLUMN_MATCH)
            return new colMatchWinStrategy();
        return null;
    }
}
