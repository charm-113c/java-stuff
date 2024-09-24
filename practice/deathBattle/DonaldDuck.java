public class DonaldDuck extends DisneyCharacter implements DoubleLife{
    private final static String NAME_DONALDDUCK = "Donal Duck";
    private static DonaldDuck instance;
    /**
     * This beauty, that you couldn't figure out in the alloted time,
     * is how you ensure that there's only one instance of a class 
     * per code run. It's a design pattern, a singleton.
     * @return DonaldDuck
     */
    public static DonaldDuck getInstance() {
        if (instance == null) {
            instance = new DonaldDuck();
        } 
        return instance;
    }
    
    private DonaldDuck() {
        this(NAME_DONALDDUCK);
    }
    private DonaldDuck(String name) {
        super(name);
    }

    @Override
    public Character wearCape() {
        return new SuperDuck();
    }

    @Override
    public Character takeOffCape() {
        return this;
    }

    private class SuperDuck extends DonaldDuck implements Superhero {
        private final static String NAME_SUPERDUCK = "Super Duck";
        private static SuperDuck instance;
        /**
         * The alternative to call SuperDuck is to make DonaldDuck static
         * Which I don't know how to do.
         * @return
         */
        public static SuperDuck getInstance() {
            if (instance == null)
                instance = DonaldDuck.getInstance().new SuperDuck();
            return instance;
        }

        private SuperDuck() {
            super(NAME_DONALDDUCK);
        }

        public void attack() {
            System.out.println("Die you scum!");
        }
    }
}
