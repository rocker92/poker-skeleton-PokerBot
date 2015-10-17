package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import com.wcs.poker.gamestate.Rank;
import com.wcs.poker.gamestate.Suit;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class PlayerTest {

    @Test
    public void testBetRequest() throws Exception {
        final GameState gameState = new GameState();

        Player ourPlayer = new Player();

        ourPlayer.setName("poker-bot");
        ourPlayer.setVersion("poker-bot 1.0");

        List<Player> jatekosok = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        Card c = new Card();

        jatekosok = gameState.getPlayers();
        
        ourPlayer = jatekosok.get(gameState.getInAction());
        
        ourPlayer.setBet(Integer.SIZE);
        
        c.setRank(Rank.TWO);
        c.setSuit(Suit.CLUBS);
        cards.add(c);

        c.setRank(Rank.KING);
        c.setSuit(Suit.DIAMONDS);
        cards.add(c);

        
//        gameState.getPlayer(ourPlayer);
        
//        assertEquals(0, Player.betRequest(gameState));
    }
}
