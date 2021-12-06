import MakeChoice.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(PushOrFold.pushOrNot(new HoldemCard(new Card(CardValues.NINE, null),
                                                                 new Card(CardValues.TEN, null)),
                                            3, Positions.MP));
    }
}
