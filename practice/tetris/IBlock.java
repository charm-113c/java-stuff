package practice.tetris;

/**
 * Second simplest, so we'll do this one too.
 * The I block has an orientation state variable,
 * telling us whether it's currently horizontal or vertical
 */
public class IBlock extends Block{
    private boolean horizontal = false;
    /**
     * By default, let's have it vertical
     */

    public IBlock(int x, int y) {
        super(x, y);
    } 

    public void rotate(int[][] screen) {
    /**
     * We need to check whether rotation is possible:
     * 1) check that we aren't going overbaord and
     * 2) check that there are no obstructions
     * and the check is dependent on the orientation state
     */
        if (horizontal) {
            // Shape: ___
            //       ^
            //      (x,y) points here
            // check that there's space above and below
            if ((this.y-1 <= 0) || (this.y+1 >= screen.length)) {
                this.draw(screen);
                return;
            }
            if ((screen[y-1][x+1] == 1) || (screen[y+1][x+1] == 1)) {
                this.draw(screen);
                return;
            }
            // in which case perform rotation
            // that is to say, change the coordinates (state variable changed later)
            this.y--;
            this.x++;
        } else {
            // Shape: | <- (x,y) points here
            //        |
            //        |
            // check that there's space to the left and right
            if ((this.x-1 <= 0) || (this.x+1 >= screen[0].length)) {
                this.draw(screen);
                return;
            }
            if ((screen[y+1][x-1] == 1) || (screen[y+1][x+1] == 1)) {
                this.draw(screen);
                return;
            }
            // else
            this.y++;
            this.x--;
        }
        this.horizontal = !this.horizontal;
        this.draw(screen);
        return;
    }

    public void left(int[][] screen) {
        /**
         * This method is also dependent of the orientation
         * And also necessitates a check that there's space
         */
        if (horizontal) {
            if ((this.x-1 <= 0 ) || (screen[y][x-1] == 1)) {
                this.draw(screen);
                return;
            }
            this.x--;
            this.draw(screen);
            return;
        }
        // else, vertical; same checks
        if ((this.x-1 <= 0) || (screen[y][x-1]+screen[y+1][x-1]+screen[y+2][x-1] > 0)) {
            this.draw(screen);
            return;
        } 
        // else, we can move left
        this.x--;
        this.draw(screen);
        return;
    }

    public void right(int[][] screen) {
        if (horizontal) {
            if ((this.x+1 > screen[0].length) || (screen[y+1][x+1] == 1)) {
                this.draw(screen);
                return;
            }
            this.x++;
            this.draw(screen);
            return;
        }
        if ((this.x+1 > screen[0].length) || (screen[y][x+1]+screen[y+1][x+1]+screen[y+2][x+1] > 0)) {
            this.draw(screen);
            return;
        }
        this.x++;
        this.draw(screen);
        return;
    }

    public void down(int[][] screen) {}
    public boolean canGoDown(int[][] screen) {return true;}
    public int[][] draw(int[][] screen) {return screen;}
}
