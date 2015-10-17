package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.robot.BetRequestProvider;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(GameState gameState) {
        BetRequestProvider betRequestProvider = new BetRequestProvider(gameState);
        return betRequestProvider.getBetRequest();
    }

    public static void showdown(GameState gameState) {
    }
}
