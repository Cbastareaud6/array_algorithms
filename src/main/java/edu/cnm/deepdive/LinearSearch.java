package edu.cnm.deepdive;

public class LinearSearch {

  public  int search (int [] hayStack, int needle) {
    int foundPosition = -1;


    for (int i = 0 ; i <hayStack.length; i++) {
      if (hayStack[i] == needle) {
        foundPosition = i;
        break;
      }
    }
    return  foundPosition;
  }

}
