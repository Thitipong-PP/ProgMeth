package logic.utility;

import logic.game.GameLogic;

public class GameLogicUtility {
    public static boolean drawRule () {
        for (int i=0; i< GameLogic.getInstance().getHand().size(); i++) if (GameLogic.getInstance().getHand().get(i).ruleCheck()) return false;
        return true;
    }
}
