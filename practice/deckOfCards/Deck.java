import java.util.LinkedHashSet;

public class Deck{
    /**
     * To represent the iterable deck (and to be extra fancy),
     * the deck itself will be represented by a linked hash set of Card's
     * No, that's too inefficient on the Shuffle method. Well, 
     * a reshuffle would be nothing more than the contruction of another 
     * deck, really. Yeah, I guess. Let's do this then.
     * Also, this way, we won't need to implement Iterable, LinkedSet already does
     * @apiNote Hi
     */
    public LinkedHashSet<Card> deck = new LinkedHashSet<>(52);
    // So this thing has O(1) on add(), contains() and remove()

    /**
     * The constructor shuffle-builds a deck of 52 different cards
     * leveraging the method equals that we've built
     */
    public Deck() {
        for (int i=0; i<52; i++) {
            // This method is... crude, there's no memory of already passed cards
            Card card = new Card(Card.Seed.getRandom(), Card.Value.getRandom());
            if (!deck.contains(card)) { deck.add(card); }
            
        }

    }
}
