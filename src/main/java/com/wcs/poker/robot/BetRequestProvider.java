/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package com.wcs.poker.robot;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author corax
 */
public class BetRequestProvider {
    
    private GameState gameState;
    private int betRequest = 10;
    
    private List<Card> cards = new ArrayList<>();
    private List<Card> ourCards = new ArrayList<>();
    
    public BetRequestProvider(GameState gameState) {
        this.gameState = gameState;
        init();
    }
    
    private void init() {
        cards = gameState.getCommunityCards();
        ourCards = gameState.getPlayers().get(gameState.getInAction()).getHoleCards();
        HandProvider hp = new HandProvider(ourCards);
        
        switch (hp.handStrenght()) {
            case 1: {
                setBetRequest(5 * (gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + gameState.getMinimumRaise()));
                break;
            }
            case 2: {
                setBetRequest(2 * (gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + gameState.getMinimumRaise()));
                break;
            }
            case 3: {
//                for (Player player : gameState.getPlayers()) {
//                    if(player.getStatus().equals("active")){
//                        if(gameState.getInAction() > player.getId() && player.getBet() > 
//                                5 * (gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + gameState.getMinimumRaise())){
//                                       setBetRequest(0);
//                                       
//                        }
//                    }
//                }
                setBetRequest(gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet());
                break;
            }            
            case 4: {
                setBetRequest(0);
            }
            
        }
        
    }
    
    public int getBetRequest() {
        return betRequest;
    }
    
    public void setBetRequest(int betRequest) {
        this.betRequest = betRequest;
    }
    
    
    
    public int OrbitNumber(){
        if (cards.isEmpty())return 0;
        if (cards.size() == 3)return 1;
        if (cards.size() == 4)return 2;
        if (cards.size() == 5)return 3;
        return 10;
    }
    
}
