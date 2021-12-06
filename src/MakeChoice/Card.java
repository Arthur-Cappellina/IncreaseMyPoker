package MakeChoice;

import java.util.*;

public class Card implements Comparable<Card> {

    public CardValues value;

    public Card(CardValues value, CardColor color) {
        this.value = value;
        this.color = color;
    }

    public CardColor color;

    public static TreeMap<CardValues, Integer> realValues = new TreeMap<CardValues, Integer>();

    static {
        realValues.put(CardValues.DEUCE, 1);
        realValues.put(CardValues.THREE, 2);
        realValues.put(CardValues.FOUR, 3);
        realValues.put(CardValues.FIVE, 4);
        realValues.put(CardValues.SIX, 5);
        realValues.put(CardValues.SEVEN, 6);
        realValues.put(CardValues.EIGHT, 7);
        realValues.put(CardValues.NINE, 8);
        realValues.put(CardValues.TEN, 9);
        realValues.put(CardValues.JACK, 10);
        realValues.put(CardValues.QUEEN, 11);
        realValues.put(CardValues.KING, 12);
        realValues.put(CardValues.ACE, 13);
    }

    public static Card convertStringToCard(String convertingString){
        CardValues cardValue = null;
        try{
            int number = Integer.parseInt(convertingString);
            cardValue = (CardValues) realValues.keySet().toArray()[number-1];
        } catch (NumberFormatException e) {
            cardValue = switch (convertingString) {
                case "A" -> CardValues.ACE;
                case "K" -> CardValues.KING;
                case "Q" -> CardValues.QUEEN;
                case "J" -> CardValues.JACK;
                case "T" -> CardValues.TEN;
                default -> cardValue;
            };
        }
        return  new Card(cardValue, null);
    }


    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        if(realValues.get(value).equals(realValues.get(o.value))) return 0;
        else if (realValues.get(value) > realValues.get(o.value)) return 1;
        else return -1;
    }

    public static List<CardValues> getAllBetterCards(CardValues cardValue){
        List<CardValues> cardsBetter = new ArrayList<CardValues>();

        int value = realValues.get(cardValue);

        for(CardValues val : realValues.keySet()){
            if(value < realValues.get(val)) cardsBetter.add(val);
        }

        return cardsBetter;
    }
}
