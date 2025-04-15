package Strategy.BotMoveStrategy;

import Model.Move;

public class EasyBotMoveStrategy implements BotMoveStrategy {

    @Override
    public Move move() {
        return new Move();
    }
}
