package practice.tetris;
/**
 * Model Tetris: create the class Block with methods
 * left(), right(), both moving the block accordingly
 * rotate() to rotate the block
 * down() to drop down the block
 * There will be five types of blocks: L-shaped, T-shaped, 
 * I-shaped, S-shaped and square blocks 
 * Finally, create the class Tetris, which gives out blocks 
 * and keeps track of the available free space the player's 
 * score, and the general state of the game
 */

 /**
  * The game will be played on a matrix of matrices, with 0s
  * representing the empty spaces and 1s the filled ones.
  * Blocks will be generated randomly, and will move down 
  * every t seconds, simulating gravity.
  */
public abstract class Block {
  protected int x, y;
  /*
   * The coordinates (x,y) of a block are the coordinates of its 
   * top left pixel of its box, independent of its orientation
   * A block's box is the smallest n*m box which can contain 
   * the block, regardless of orientation, but not all blocks
   * need one (i.e., I- and Square-blocks). 
   */

  public Block(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public abstract void rotate(int[][] screen);
  /* This method rotates the block within the screen 
  and returns the updated screen */

  public abstract void left(int[][] screen);
  public abstract void right(int[][] screen);
  public abstract void down(int[][] screen);

  public abstract boolean canGoDown(int[][] screen);
  /**
   * This method returns true if the block can still go down.
   * It's an indicator of whether the block is placed or can 
   * still move.
   */

   public abstract int[][] draw(int[][] screen);
   /**
    * Since movement methods are void, at the end of each call 
    * we draw the state of the screen for the user.
    */
}
