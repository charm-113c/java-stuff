package model;

import java.util.List;

public class Player {
    public int designation;
    private double wealth;
    private Neighbourhood neighbourhood;

    public Player(int d, double wealth, Neighbourhood neighbourhood) {
        designation = d;
        this.wealth = wealth;
        this.neighbourhood = neighbourhood;
    }
    public void setNeighbourhood(List<Integer> acq, List<Integer> refl) {
        this.neighbourhood = new Neighbourhood(acq, refl);
    }

    /**
     * Neighbourhoods being complex and requiring complex operations, we make them
     * into a nested class.
     * A player has neighbourhood ( (d, 1), (e, 7), ...)
     * with d, e and the first elem of the inner tuples being acquaintances
     * and 1, 7 and all second elems being the position of current player in their 
     * neighbourhoods.
     * To simplify, we aggregate the acquaintances in an arraylist and the 
     * positions in another.
     */
    public class Neighbourhood {
        private List<Integer> acquaintainces;
        private List<Integer> reflections;

        public Neighbourhood(List<Integer> acq, List<Integer> refl) {
            acquaintainces = acq;
            reflections = refl;
        }

        public List<Integer> getAcquaintances() { return this.acquaintainces; }
        public List<Integer> getReflections() { return this.reflections; }

    }
}
