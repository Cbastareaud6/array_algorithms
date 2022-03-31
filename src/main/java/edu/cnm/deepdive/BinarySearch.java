package edu.cnm.deepdive;

public class BinarySearch {


  public int search(int[] hayStack, int needle) {

     return search(hayStack, needle, 0, hayStack.length);
  }
  public int search(int[] hayStack, int needle, int startPosition , int endPosition) {
    int foundPosition =
        (-startPosition) -1; // Fixme?
    if (endPosition > startPosition) {
   int midPointPosition = (startPosition + endPosition) / 2;
   int midPointValue = hayStack[midPointPosition];
   if (midPointValue == needle) {
     // Found it at midPos
     foundPosition = midPointPosition;
   } else if (midPointValue < needle) {
     // Search right-hand side
     foundPosition = search(hayStack, needle, midPointPosition+1 , endPosition);
   } else {
     // search left-hand side
     foundPosition = search(hayStack, needle, startPosition, midPointPosition);
   }
    }
    return foundPosition;
  }
}
