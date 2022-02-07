package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 *  Implements a lottery to experiment our fair shuffle (Fisher Yates algorithm) method.
 */
public class Lottery {




  private final int poolSize;
  private  final int drawSize;
  private final Random rng;
  private final Shuffler s;
  private int[] pool;
  final int POOLSIZE = 80;
  final int DRAWSIZE = 5;


  /**
   * Initializes our lottery object with a specified pool size, a specified draw size
   * a specified source of randomness and a shuffler object.
   * @param args
   */
  public Lottery(String[] args) {
    if ( args.length == 0) {
      poolSize = POOLSIZE;

    } else {
      poolSize = Integer.parseInt(args[0]);
    }

    if (args.length <2) {
      drawSize = DRAWSIZE;

    } else {
      drawSize = Integer.parseInt(args[1]);

    }

    rng = new SecureRandom();
    s = new Shuffler(rng);
    pool = new int[poolSize];
    for (int i = 0; i < poolSize; i++) {
      pool[i] = i + 1;

    }

  }

  /**
   * Implements a draw that evaluate if the specified array is to be sorted and returns the result sample.
   * @param sorted Evaluate if the sample is to be sorted.
   * @return Return the sample that may or may not have been sorted.
   */

  public int[] draw(boolean sorted) {
    int[] sample = s.draw(pool, drawSize);
    if (sorted) {
      Arrays.sort(sample);
    }
    return sample;
  }

  /**
   *  Displays and prints the result.
   * @param draw An array of integer called draw.
   */
  public void display(int[] draw){
    System.out.printf("Drawing %d numbers from a pool of %d: %s5=%n",drawSize, poolSize,
        Arrays.toString(draw));

  }

  /**
   *  Application entry point for our lottery object.
   * @param args
   */
  public static void main(String[] args) {
    Lottery lotto = new Lottery(args);

    int[] draw = new int[0];
    for (int i = 0; i < 2; i++) {

      if (args.length > 2) {
        i = Integer.parseInt(args[2]);
      }

        draw = lotto.draw(true);


      lotto.display(draw);
    }




   }

}
