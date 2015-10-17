/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.robot;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;
import java.util.List;

/**
 *
 * @author corax
 */
public class HandProvider {

    private Card elso;
    private Card masodik;

    public Card getElso() {
        return elso;
    }

    public void setElso(Card elso) {
        this.elso = elso;
    }

    public Card getMasodik() {
        return masodik;
    }

    public void setMasodik(Card masodik) {
        this.masodik = masodik;
    }

    public HandProvider(List<Card> ourCards) {
        this.elso = ourCards.get(0);
        this.masodik = ourCards.get(1);
    }

    public int handStrenght() {
        if (isBigCards()) {
            return 1;
        }
        else
        {
        if (isStrongCards()){
            return 2;
        }
        }
        return 4;
        
    }

    public boolean isBigCards() {
        if ((elso.getRank().equals(Rank.ACE)
                || elso.getRank().equals(Rank.KING))
                && elso.getRank().equals(masodik.getRank())) {
            return true;
        }
        return false;
    }

    public boolean isStrongCards() {
        if ((elso.getRank().equals(Rank.TEN)
                || elso.getRank().equals(Rank.QUEEN) 
                || elso.getRank().equals(Rank.JACK)) 
                && elso.getRank().equals(masodik.getRank())) {
            return true;
        }
        if ((elso.getRank().equals(Rank.ACE)
                || elso.getRank().equals(Rank.KING))
                && (masodik.getRank().equals(Rank.ACE)
                || masodik.getRank().equals(Rank.KING))) {
            return true;
        }
        return false;
    }
}
