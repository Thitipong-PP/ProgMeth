package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class BaseCard {

    private CardColor color;
    private CardSymbol symbol;

    public BaseCard () {}

    public BaseCard (CardColor color) {
        setColor(color);
    }

    public CardColor getColor () {
        return this.color;
    }

    public void setColor (CardColor color) {
        this.color = color;
    }

    public CardSymbol getSymbol () {
        return this.symbol;
    }

    public void setSymbol (CardSymbol symbol) {
        this.symbol = symbol;
    }

    public void play () {

    }

    public boolean ruleCheck () {
        if (GameLogic.getInstance().getTopCard().getColor() == this.getColor()) return true;
        return false;
    }

}
