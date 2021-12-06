package MakeChoice;

import java.util.ArrayList;
import java.util.List;

public class PushOrFold {

    public static boolean pushOrNot(HoldemCard cards, int blind, Positions p){
        boolean shouldPush = false;

        List<HoldemCardPredict> minimalCombinaisons = getMinimalCombinaisons(p, blind);
        if(cards.isPair() && minimalCombinaisons.get(0).card1.compareTo(cards.card1) <= 0) shouldPush = true;
        List<HoldemCard> ableToPush = getAllCombinaisons(getMinimalCombinaisons(p, blind));

        return shouldPush;
    }

    public static List<HoldemCard> getAllCombinaisons(List<HoldemCardPredict> minimal) {
        List<HoldemCard> combinaisons = new ArrayList<HoldemCard>();
        for(HoldemCardPredict c : minimal){
            // On a trois cas soit la chaine contient x soit o soit s
            // Il se peut qu'il n'y est pas de plus
            if(!c.isPlus) combinaisons.add((HoldemCard)c);
            else if(c.all){

                // Liste des cartes meilleurs (x)
                List<CardValues> cardsX = new ArrayList<CardValues>();
                cardsX.add(c.card1.value);
                cardsX.addAll(Card.getAllBetterCards(c.card1.value));

                for(CardValues xCombinaisions : cardsX){
                    for(CardValues val : Card.realValues.keySet()){
                        combinaisons.add(new HoldemCard(new Card(xCombinaisions, null), new Card(val, null)));
                        combinaisons.add(new HoldemCard(new Card(xCombinaisions, null), new Card(val, null), true));
                    }
                }
            }
        }

        System.out.println(combinaisons);
        return null;
    }


    // Blind -> liste de combinaisons associé
    public static List<HoldemCardPredict> getMinimalCombinaisons(Positions p, int blind){
        String brutCombinaitions = getBrutCombinaitions(p, blind);

        Card c1Temp, c2Temp;


        ArrayList<HoldemCardPredict> cards = new ArrayList<HoldemCardPredict>();

        brutCombinaitions = brutCombinaitions.replace("\n", " ");
        for(String s : brutCombinaitions.split(" ")){
            if(!s.contains("%")) {
                c1Temp = Card.convertStringToCard("" + s.toCharArray()[0]);
                c2Temp = Card.convertStringToCard("" + s.toCharArray()[1]);
                boolean isPlus = s.contains("+");
                boolean all = s.contains("x");
                if(s.toCharArray()[2] == 'o') cards.add(new HoldemCardPredict(c1Temp, c2Temp, false, isPlus, all));
                else cards.add(new HoldemCardPredict(c1Temp, c2Temp, true, isPlus, all));
            }
        }

        return cards;
    }

    /**
     * Methode qui retourne toutes les combinaisons minimales nécessaires sous forme de chaine
     * @return la chaine des combinaisons minimales
     */
    public static String getBrutCombinaitions(Positions p, int blinds){
        return Table.getTable().get(blinds).get(p);
    }

}
