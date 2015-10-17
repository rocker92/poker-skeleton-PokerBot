/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.robot;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author corax
 */
public class HandProvider {

    private Card elso;
    private Card masodik;
    private List<Rank> varakozoLapokhoz = new ArrayList<>();

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
    
    private void initVarakozoLapokhoz(){
        varakozoLapokhoz.add(Rank.NINE);
        varakozoLapokhoz.add(Rank.TEN);
        varakozoLapokhoz.add(Rank.JACK);
        varakozoLapokhoz.add(Rank.QUEEN);
    }

    public int handStrenght() {
        if (isBigCards()) {
            return 1;
        }
        if (isStrongCards()){
            return 2;
        }
        if(isWaitingCards()){
            return 3;
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

    public boolean isWaitingCards(){
        //9-2 pár
        if(elso.getRank().equals(masodik.getRank())) return true;
        
        //A 9-Q kísérővel
        if(elso.getRank().equals(Rank.ACE) && elso.getSuit().equals(masodik.getSuit())) return true;
        if(masodik.getRank().equals(Rank.ACE) && elso.getSuit().equals(masodik.getSuit())) return true;
        
        //A azonos színűvel
        if(elso.getRank().equals(Rank.ACE) && (varakozoLapokhoz.contains(masodik.getRank()))) return true;
        if(masodik.getRank().equals(Rank.ACE) && (varakozoLapokhoz.contains(elso.getRank()))) return true;
        
        //2 azonos szín, ha > 10
        if(elso.getSuit().equals(masodik.getSuit()) && (varakozoLapokhoz.contains(elso.getRank()) && varakozoLapokhoz.contains(masodik.getRank()))) return true;
        return false;
    }
    
    
}
