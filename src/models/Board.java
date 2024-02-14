package models;

import java.util.Map;

public class Board {
  private Map<Integer, Integer> snakes;
  private Map<Integer, Integer> ladders;

  public Board(Map<Integer, Integer> snakes,
      Map<Integer, Integer> ladders) {
    this.snakes = snakes;
    this.ladders = ladders;
  }

  public boolean hasSnake(int pos) {
    return snakes.containsKey(pos);
  }

  public boolean hasLadder(int pos) {
    return ladders.containsKey(pos);
  }

  public int getSnakeEnd(int pos) {
    if(hasSnake(pos))
      return snakes.get(pos);
    return -1;
  }

  public int getLadderTop(int pos) {
    if(hasLadder(pos))
      return ladders.get(pos);
    return -1;
  }

}
