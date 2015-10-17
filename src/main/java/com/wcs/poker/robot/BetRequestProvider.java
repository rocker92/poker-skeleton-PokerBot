/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package com.wcs.poker.robot;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

/**
 *
 * @author corax
 */
public class BetRequestProvider {

    private GameState gameState;
    private int betRequest = 10;

    public BetRequestProvider(GameState gameState) {
        this.gameState = gameState;
        init();
    }

    private void init() {
        List<Card> cards = gameState.getCommunityCards();
        List<Card> ourCards = gameState.getPlayers().get(gameState.getInAction()).getHoleCards();
        HandProvider hp = new HandProvider(ourCards);

        switch (hp.handStrenght()){
            case 1: {
                setBetRequest(5*(gameState.getCurrentBuyIn()-gameState.getPlayers().get(gameState.getInAction()).getBet()+gameState.getMinimumRaise()));
                break;
            }
            case 2:{
                setBetRequest(2*(gameState.getCurrentBuyIn()-gameState.getPlayers().get(gameState.getInAction()).getBet()+gameState.getMinimumRaise()));
                break;
            }
            case 3: break;
            case 4: break;

        }
        
        }

    

    public int getBetRequest() {
        return betRequest;
    }

    public void setBetRequest(int betRequest) {
        this.betRequest = betRequest;
    }

}
