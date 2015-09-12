package com.wcs.poker.gamestate;

import com.google.gson.annotations.SerializedName;

public enum Rank {

    @SerializedName("2") TWO,
    @SerializedName("3") THREE,
    @SerializedName("4") FOUR,
    @SerializedName("5") FIVE,
    @SerializedName("6") SIX,
    @SerializedName("7") SEVEN,
    @SerializedName("8") EIGHT,
    @SerializedName("9") NINE,
    @SerializedName("10") TEN,
    @SerializedName("J") JACK,
    @SerializedName("Q") QUEEN,
    @SerializedName("K") KING,
    @SerializedName("A") ACE;
}
