package services.impl;

import java.util.Scanner;
import models.Board;
import models.Dice;
import models.Player;
import services.Gameplay;
import services.InitGame;

public class SnakeLadderGameplay implements Gameplay {
  private Board board;
  private Player playerA;
  private Player playerB;
  private Dice dice;
  private boolean isGameOn;
  private Player currentPlayer;
  private String playerAName;
  private String playerBName;

  public SnakeLadderGameplay(String playerAName, String playerBName) {
    this.playerAName = playerAName;
    this.playerBName = playerBName;
  }

  private void startGame() {
    InitGame initGame = new InitSnakeLadder();
    board = initGame.setUpBoard();
    playerA = initGame.createPlayer(playerAName, 0);
    playerB = initGame.createPlayer(playerBName, 0);
    dice = initGame.getDice();
    isGameOn = true;
    currentPlayer = playerA;
  }

  private void endGame() {
    isGameOn = false;
    System.out.println("Game Over!!!");
  }

  private void changePlayer() {
    if(currentPlayer.equals(playerA)) {
      currentPlayer = playerB;
    } else {
      currentPlayer = playerA;
    }
  }

  private void playChance() {
    int diceFace = dice.rollDice();
    System.out.println("dice: " + diceFace);
    int pos = currentPlayer.getPosition() + diceFace;
    if(pos <= 100) {
      currentPlayer.setPosition(pos);
      System.out.println(currentPlayer.getName() + " reaches to " + currentPlayer.getPosition());
      if(board.hasLadder(pos)) {
        currentPlayer.setPosition(board.getLadderTop(pos));
        System.out.println(currentPlayer.getName() + " got ladder and reaches to " + currentPlayer.getPosition());
      } else if(board.hasSnake(pos)) {
        currentPlayer.setPosition(board.getSnakeEnd(pos));
        System.out.println(currentPlayer.getName() + " got snake and reaches to " + currentPlayer.getPosition());
      }
    }
    if(currentPlayer.getPosition() == 100) {
      currentPlayer.setWon(true);
      System.out.println(currentPlayer.getName() + " won !!");
      endGame();
    }
  }

  public void playGame() {
    startGame();
    Scanner scanner = new Scanner(System.in);
    while (isGameOn) {
      System.out.println(currentPlayer.getName() + "'s turn. Press ENTER to roll a dice");
      scanner.nextLine();
      playChance();
      if(isGameOn) {
        changePlayer();
      }
    }
  }
}
