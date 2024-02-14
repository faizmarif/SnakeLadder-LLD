package models;

import java.util.Random;

public class Dice {
  private int face;
  private Random diceRoller;

  public Dice() {
    diceRoller = new Random();
  }

  public int getFace() {
    return face;
  }

  public void setFace(int face) {
    this.face = face;
  }

  public int rollDice() {
    int x = diceRoller.nextInt(6) + 1;
    setFace(x);
    return x;

  }
}
