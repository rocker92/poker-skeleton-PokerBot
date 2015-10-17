
package com.wcs.poker.gamestate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Player {

    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private PlayerStatus status;
    @Expose
    private String version;
    @Expose
    private Integer stack;
    @Expose
    private Integer bet;
    @SerializedName("hole_cards")
    @Expose
    private List<Card> holeCards = new ArrayList<Card>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The status
     */
    public PlayerStatus getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The stack
     */
    public Integer getStack() {
        return stack;
    }

    /**
     * 
     * @param stack
     *     The stack
     */
    public void setStack(Integer stack) {
        this.stack = stack;
    }

    /**
     * 
     * @return
     *     The bet
     */
    public Integer getBet() {
        return bet;
    }

    /**
     * 
     * @param bet
     *     The bet
     */
    public void setBet(Integer bet) {
        this.bet = bet;
    }

    /**
     * 
     * @return
     *     The holeCards
     */
    public List<Card> getHoleCards() {
        return holeCards;
    }

    /**
     * 
     * @param holeCards
     *     The hole_cards
     */
    public void setHoleCards(List<Card> holeCards) {
        this.holeCards = holeCards;
    }

    public void assertEquals(int i, int betRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
