package practice.tetris;

/**
 * The easiest class to implement, so we'll do it first to 
 * get an idea of what to do. Because it's a square, the 
 * coords will point to the top left corner, the other pixels
 * are left implicit
 */
public class SquareBlock extends Block{
    /*
     * Because it's a square, there's no need for a `orientation`
     * variable, and rotate() changes nothing.
     */
    public SquareBlock(int x, int y) {
        super(x, y);
    }

    public void rotate(int[][] screen) {
        this.draw(screen);
        return;
    }

    public void left(int[][] screen) {
        /**
         * Before moving the block left, we must check that
         * 1) the screen border isn't immediately to the left and
         * 2) there is enough space on the screen to go left
         */
        if (this.x <= 0) {
            this.draw(screen);
            return;
        }
        boolean obstructed = (screen[y][x-1] == 1) || (screen[y-1][x-1] == 1);
        if (obstructed) {
            this.draw(screen);
            return;
        }
        // otherwise we move the block left
        this.x--;
        // that is, we move its x coordinate to the left.
        this.draw(screen);
        return;
    }

    public void right(int[][] screen) {
        /**
         * We do much the same thing as for left
         */
        if (this.x+2 >= screen[0].length) {
            /**
             * Reminder that coords are the upper left pixel,
             * hence the +2 to check the right side of the block
             */
            this.draw(screen);
            return;
        }
        if ((screen[y][x+2] == 1) || (screen[y+1][x+2] == 1)) {
            this.draw(screen);
            return;
        }
        this.x++;
        this.draw(screen);
        return;
    }

    public void down(int[][] screen) {
        /**
         * The process is the same as for the previous methods
         */
        if (this.y >= screen.length) {
            this.draw(screen);
            return;
        }
        if ((screen[y+2][x] == 1) || (screen[y+2][x+1] == 1)) {
            this.draw(screen);
            return;
        }
        this.y++;
        this.draw(screen);
        return;
    }

    public boolean canGoDown(int[][] screen) {
        /**
         * This does much the same as down, except that we do not 
         * move the block, we merely perform the check
         */
        if ((this.y >= screen.length) || ((screen[y+2][x] == 1) || (screen[y+2][x+1] == 1))) {
            return false;
        }
        return true;
    }

    public int[][] draw(int[][] screen) {
        /**
         * This method assumes that the block can be placed 
         * in its current coordinates. In other words, all other methods 
         * must ensure that we're never in an illegal position.
         * Since we're not modifying the screen, we will be drawing
         * a deep copy of it
         */
        int[][] drawing = new int[screen.length][screen[0].length];
        for (int y_i = 0; y_i < drawing.length; y_i++) {
            for (int x_i = 0; x_i < drawing[0].length; x_i++) {
                drawing[y_i][x_i] = screen[y_i][x_i];
            }
        }
        // Then we draw the block too
        drawing[this.y][this.x] = 1; // upper left pixel
        drawing[this.y][this.x+1] = 1; // upper right pixel
        drawing[this.y+1][this.x] = 1; // lower left pixel
        drawing[this.y+1][this.x+1] = 1; // lower right pixel
        return drawing;
    }
}
