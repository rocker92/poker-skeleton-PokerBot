package org.leanpoker.player;


import com.wcs.poker.gamestate.GameState;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testBetRequest() throws Exception {
        final GameState gameState = new GameState();
        
        com.wcs.poker.gamestate.Player miJatekosunk = new com.wcs.poker.gamestate.Player();
        
        miJatekosunk.setName("poker-bot");
        miJatekosunk.setVersion("poker-bot 1.0");
        
        assertEquals(0, Player.betRequest(gameState));
    }
}
