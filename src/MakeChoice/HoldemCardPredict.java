package MakeChoice;

import MakeChoice.Card;
import MakeChoice.HoldemCard;

public class HoldemCardPredict extends HoldemCard {

    public boolean isPlus;

    // Si on tapis toutes les mains avec une des 2 cartes
    public boolean all;


    public HoldemCardPredict(Card card1, Card card2, boolean isSuited, boolean isPlus, boolean all) {
        super(card1, card2, isSuited);
        this.isPlus = isPlus;
        this.all = all;
    }

    @Override
    public String toString() {
        return super.toString() + " isPlus = " + isPlus;
    }
}
