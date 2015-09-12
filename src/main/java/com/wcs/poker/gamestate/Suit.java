package com.wcs.poker.gamestate;

import com.google.gson.annotations.SerializedName;

public enum Suit {

    @SerializedName("clubs") CLUBS,
    @SerializedName("spades") SPADES,
    @SerializedName("hearts") HEARTS,
    @SerializedName("diamonds") DIAMONDS;
}
