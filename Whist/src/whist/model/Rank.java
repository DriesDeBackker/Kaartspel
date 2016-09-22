package whist.model;

import java.util.HashMap;

public enum Rank {
	TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), 
	NINE(8), TEN(9), JACK(10), QUEEN(11), KING(12), ACE(13);
	
	private int value;
    private static HashMap<Object, Object> map = new HashMap<>();

    private Rank(int value) {
        this.value = value;
    }

    static {
        for (Rank rank : Rank.values()) {
            map.put(rank.value, rank);
        }
    }

    public static Rank valueOf(int rank) {
        return (Rank) map.get(rank);
    }

    public int getValue() {
        return value;
    }

}
