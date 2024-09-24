import java.util.Random;

public class Card{
    private Seed seed;
    private Value value;

    public static enum Seed {
        DIAMOND, HEART, SPADES, CLUB;
        private Random random = new Random();
        public static Seed getRandom() {
            switch (random.nextInt()%4) {
                case 0:
                    return DIAMOND;
                case 1:
                    return HEART;
                case 2:
                    return SPADES;
                default:
                    return CLUB;
            }
        }
    }
    public static enum Value {
        ACE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK("11"), QUEEN("12"), KING("13");
        private String val;
        private Value(String val) {
            this.val = val;
        }
        public static Value getRandom() {
            Random random = new Random();
            Integer r = random.nextInt()%14 + 1;
            return Card.Value.valueOf(r.toString());
            }
        }
    

    public Card(Seed seed, Value value) {
        this.seed = seed;
        this.value = value;
    }

    public String toString() {
        String s = "Seed:" + this.seed.toString();
        String v = ", Value:" + this.value.toString();
        return s+v;
    }

    public boolean equals(Card card) {
        return (this.seed == card.seed) && (this.value == card.value);
    }
    @Override
    public boolean equals(Object o) {
        // check if same me address
        if (this == o) return true;
        if ((o==null) || !this.getClass().equals(o.getClass())) return false;
        // Downcast object to Card
        Card otheCard = (Card) o;
        return equals(otheCard);
    }
    // When implementing equals, it is customary to also override hashCode
    // @Override
    // public int hashCode() {
    //     // use a(ny) prime number and use this obscure formula
    //     return 13*this.getSeed().hashCode() + this.getValue().hashCode();
    // }
}