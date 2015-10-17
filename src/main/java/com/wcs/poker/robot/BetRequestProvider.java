/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package com.wcs.poker.robot;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import com.wcs.poker.gamestate.Rank;
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
    private List<Rank> nagyLapok = new ArrayList<>();

    private Integer minimumEmeles;
    private int megad;

    public BetRequestProvider(GameState gameState) {
        this.gameState = gameState;
        this.minimumEmeles = gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + gameState.getMinimumRaise();
        this.megad = gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet();
        init();
    }

    private void init() {
        cards = gameState.getCommunityCards();
        ourCards = gameState.getPlayers().get(gameState.getInAction()).getHoleCards();
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(cards);
        allCards.addAll(ourCards);
        HandProvider hp = new HandProvider(ourCards);

        if (cards.isEmpty()) {
            switch (hp.handStrenght()) {
                case 1: {
                    setBetRequest(gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + 3 * gameState.getMinimumRaise());
                    break;
                }
                case 2: {
                    setBetRequest(gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + 2 * gameState.getMinimumRaise());
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
        } else {

            //setBetRequest(cardStrenght() * (gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + gameState.getMinimumRaise()));
            switch (cardStrenght(allCards)) {
                case 2: {
                    if (!hp.isPairInHand()) {
                        setBetRequest(0);
                    }
                    else{
                    if (nagyLapok.contains(isPair(allCards))) {
                        setBetRequest(gameState.getCurrentBuyIn() - gameState.getPlayers().get(gameState.getInAction()).getBet() + gameState.getMinimumRaise());
                    } else {
                        emelesDontes();
                    }}
                }
                case 3: {
                    if (!hp.isPairInHand()) {
                        setBetRequest(0);
                    }
                    setBetRequest(megad + 50);
                }
                case 4: {
                    setBetRequest(megad + 100);
                }

            }

        }

    }

    private void emelesDontes() {
        for (Player player : gameState.getPlayers()) {
            if (player.getStatus().equals("active")) {
                if (gameState.getInAction() > player.getId() && player.getBet()
                        > minimumEmeles) {
                    setBetRequest(0);

                } else {
                    setBetRequest(megad);
                }
            }
        }
    }

    private void initNagyLapok() {
        nagyLapok.add(Rank.NINE);
        nagyLapok.add(Rank.TEN);
        nagyLapok.add(Rank.JACK);
        nagyLapok.add(Rank.QUEEN);
        nagyLapok.add(Rank.KING);
        nagyLapok.add(Rank.ACE);
    }

    public int getBetRequest() {
        return betRequest;
    }

    public void setBetRequest(int betRequest) {
        this.betRequest = betRequest;
    }

    public int cardStrenght(List<Card> allCards) {
        if (isroyalFlush(allCards)) {
            return 10;
        }
        if (isPair(allCards) != null) {
            return 2;
        }
        if (isTwoPair(allCards)) {
            return 3;
        }
        if (isDrill(allCards)) {
            return 4;
        }
        return 5;//10 kat
    }

    public Rank isPair(List<Card> allCards) {
        for (int i = 0; i < allCards.size() - 1; i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getRank().equals(allCards.get(j).getRank())) {
                    return allCards.get(i).getRank();
                }
            }
        }
        return null;
    }

    public boolean isTwoPair(List<Card> allCards) {
        boolean[] parok = new boolean[allCards.size()];
        for (int i = 0; i < allCards.size() - 1; i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if ((!parok[i] && !parok[j]) && allCards.get(i).getRank().equals(allCards.get(j).getRank())) {
                    parok[i] = true;
                    parok[j] = true;
                }
            }
        }
        int szamlalo = 0;
        for (int i = 0; i < parok.length; i++) {
            if (parok[i]) {
                szamlalo++;
            }
            if (szamlalo > 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isDrill(List<Card> allCards) {

        for (int i = 0; i < allCards.size() - 1; i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getRank().equals(allCards.get(j).getRank())) {
                    for (int k = j + 1; k < allCards.size(); k++) {
                        if (allCards.get(j).equals(allCards.get(k))) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isStraight(List<Card> allCards) {
        return false;
    }

    public boolean isFlush(List<Card> allCards) {
        return false;
    }

    public boolean isFull(List<Card> allCards) {
        return false;
    }

    public boolean isPoker(List<Card> allCards) {
        return false;
    }

    public boolean isSuitStraight(List<Card> allCards) {
        return false;
    }

    public boolean isroyalFlush(List<Card> allCards) {
        return false;
    }

    public int OrbitNumber() {
        if (cards.isEmpty()) {
            return 0;
        }
        if (cards.size() == 3) {
            return 1;
        }
        if (cards.size() == 4) {
            return 2;
        }
        if (cards.size() == 5) {
            return 3;
        }
        return 10;
    }

}
