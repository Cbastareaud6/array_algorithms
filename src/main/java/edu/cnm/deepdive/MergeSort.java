package edu.cnm.deepdive;

import java.util.Arrays;

public class MergeSort {

  public void sort(int[] data) {
    sort(data, 0, data.length);

  }

  public void sort(int[] data, int startPosition, int endPosition) {
    if (endPosition > startPosition + 1) {
      // divide

      int midPosition = (startPosition + endPosition) / 2;
      // conquer

      sort(data, startPosition, midPosition);
      sort(data, midPosition, endPosition);
      // merge
      int[] merged = new int[endPosition - startPosition];
      int mergedPosition = 0;
      int leftPosition = startPosition;
      int rightPosition = midPosition;
      while (leftPosition < midPosition && rightPosition < endPosition) {
        int leftValue = data[leftPosition];
        int rightValue = data[rightPosition];
        if (leftValue <= rightValue) {
          merged[mergedPosition] = leftValue;
          mergedPosition++;
          leftPosition++;
        } else {
          merged[mergedPosition] = rightValue;
          mergedPosition++;
          rightPosition++;

        }
      }
      if(leftPosition <midPosition) {
        System.arraycopy(data, leftPosition, merged, mergedPosition, midPosition-leftPosition);

      } else {
        System.arraycopy(data, rightPosition, merged, mergedPosition, endPosition-rightPosition);

      }
      System.arraycopy(merged, 0, data, startPosition, merged.length);
    }



  }


}

