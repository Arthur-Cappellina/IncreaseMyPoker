package MakeChoice;

public class HoldemCard {

    public Card card1, card2;

    public HoldemCard(Card card1, Card card2, boolean isSuited) {
        this.card1 = card1;
        this.card2 = card2;
        this.isSuited = isSuited;
    }

    public boolean isPair(){
        return card1.value.equals(card2.value);
    }

    public boolean isSuited;

    public HoldemCard(Card card1, Card card2) {
        this.card1 = card1;
        this.card2 = card2;
        isSuited = false;
    }


    @Override
    public String toString() {
        return "HoldemCard : " + card1 +
                " " + card2 +
                ", suité ? " + isSuited +
                "\n";
    }
}
