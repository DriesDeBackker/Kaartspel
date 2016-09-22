package whist.model;

import java.util.HashMap;

public enum Suit {
    HEARTS(1),
    DIAMONDS(2),
    CLUBS(3),
	SPADES(4);

    private int value;
    private static HashMap<Object, Object> map = new HashMap<>();

    private Suit(int value) {
        this.value = value;
    }

    static {
        for (Suit suit : Suit.values()) {
            map.put(suit.value, suit);
        }
    }

    public static Suit valueOf(int suit) {
        return (Suit) map.get(suit);
    }

    public int getValue() {
        return value;
    }
}