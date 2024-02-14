package services.impl;

import java.util.HashMap;
import java.util.Map;
import models.Board;
import models.Dice;
import models.Player;
import services.InitGame;

public class InitSnakeLadder implements InitGame {

  @Override
  public Board setUpBoard() {
    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladders = new HashMap<>();

    snakes.put(33,6);
    snakes.put(41,20);
    snakes.put(49,9);
    snakes.put(56,53);
    snakes.put(62,5);
    snakes.put(87,16);
    snakes.put(93,73);
    snakes.put(95,75);
    snakes.put(98,64);

    ladders.put(2,37);
    ladders.put(10,32);
    ladders.put(27,46);
    ladders.put(51,68);
    ladders.put(61,79);
    ladders.put(65,84);
    ladders.put(71,91);
    ladders.put(81,100);

    return new Board(snakes, ladders);
  }

  @Override
  public Player createPlayer(String name, int pos) {
    return new Player(name, pos);
  }

  @Override
  public Dice getDice() {
    return new Dice();
  }
}
