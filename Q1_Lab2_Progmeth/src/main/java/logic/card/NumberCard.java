package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class NumberCard extends BaseCard {
    public NumberCard (CardColor color, CardSymbol symbol) {
        this.setColor(color);
        this.setSymbol(symbol);
    }

    public void play () {
        GameLogic.getInstance().setTopCard(this);
    }

    public boolean ruleCheck () {
        if (GameLogic.getInstance().getTopCard().getColor() == this.getColor() || GameLogic.getInstance().getTopCard().getSymbol() == this.getSymbol()) {
            return true;
        }

        return false;
    }
}
