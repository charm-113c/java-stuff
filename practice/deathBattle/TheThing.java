public class TheThing extends MarvelCharacter implements Superhero{
    private static final String NAME_THETHING = "The Thing";
    /**
     * Once again we only want one instance of this class
     */
    private static TheThing instance;

    public static TheThing getInstance() {
        if (instance == null)
            instance = new TheThing();
        return instance;
    }

    private TheThing() {
        super(NAME_THETHING);
    }

    public void attack() {
        System.out.println("Perish you inferior being!");
    }
}
