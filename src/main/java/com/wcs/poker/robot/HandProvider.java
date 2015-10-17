/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.robot;

import com.wcs.poker.gamestate.Card;

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

    public HandProvider(Card elso, Card masodik) {
        this.elso = elso;
        this.masodik = masodik;
    }
    
    

}
