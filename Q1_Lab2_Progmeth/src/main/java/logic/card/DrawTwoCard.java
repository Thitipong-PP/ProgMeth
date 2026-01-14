package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class DrawTwoCard extends BaseCard {
    public DrawTwoCard (CardColor color) {
        this.setColor(color);
        this.setSymbol(CardSymbol.DRAW);
    }

    public void play () {
        GameLogic.getInstance().setTopCard(this);
        GameLogic.getInstance().draw(2);
    }

    public boolean ruleCheck () {
        if (GameLogic.getInstance().getTopCard().getColor() == this.getColor()) return true;
        return false;
    }
}
