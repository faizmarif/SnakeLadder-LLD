package services;

import models.Board;
import models.Dice;
import models.Player;

public interface InitGame {

  Board setUpBoard();

  Player createPlayer(String name, int pos);

  Dice getDice();
}
