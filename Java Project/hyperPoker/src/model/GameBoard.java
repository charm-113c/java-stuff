package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * A gameboard has k players with an initial total wealth Wealth. A game will
 * last at most nRounds.
 * Each game will record its own history as well a list of inactive players and
 * a profile (the latter two
 * are updated every new round).
 */
public class GameBoard {
    public int k;
    public int Wealth;
    public int nRounds;

    private HashMap<Integer, HashMap<String, int[]>> history;
    private List<Player> players;
    private List<Integer> inactivePlayers;
    private HashMap<Integer, Integer> profile;

    public GameBoard(int k, int Wealth, int nRounds) {
        this.k = k;
        this.Wealth = Wealth;
        this.nRounds = nRounds;

        players = this.initializeGame();
    }

    /**
     * k players are initialized by assigning them a random share of the Wealth/2,
     * and they are also
     * each given an half-full neighbourhood of k/2 players (-1 if k is odd).
     * 
     * @return those players.
     */
    public List<Player> initializeGame() {
        // Didive Wealth/2 randomly between k players
        double[] wealths = new double[k];
        Random rng = new Random();

        wealths = Arrays.stream(wealths)
                .map(x -> x + 0.001) // Ensure no player starts with 0
                .map(x -> x + rng.nextDouble(0, 1)) // Then randomize each value
                .toArray();
        // We now have an array of k elems with values between a base value and 1, but
        // the array does not sum up to 1
        // So we normalize it, then multiply its elements by Wealth/2
        double normFactor = Arrays.stream(wealths).sum();
        final double[] nWealths = Arrays.stream(wealths)
                .map(x -> (x * Wealth) / (2 * normFactor))
                .toArray();

        // Then create k neighbourhoods of k/2 players for all
        HashMap<Integer, List<Integer[]>> neighb = new HashMap<Integer, List<Integer[]>> () {{
            for (int i=1; i<k; i++) {
                // A neighbourhood consists of array of acquaintances
                // and own position in acquaintances' neighbourhoods
                put(i, )

                // If d has e in its neighb, then e has d in its neighb
                /**
                 * For d, add players until their neighb has size >= k/2
                 * Then go through d's neighb, and for each player in it
                 * add d to their neighb. Upon coming back update d's 
                 * reflection array.
                 * Then move to player e and do the same
                 */

            }
        }};

        return null;
    }

    public HashMap<Integer, HashMap<String, int[]>> getHistory() { return this.history; }
    public List<Integer> getInactivePlayers() { return this.inactivePlayers; }
}
