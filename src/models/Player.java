package models;

public class Player {
  String name;
  boolean playing;
  boolean won;
  int position;

  public Player(String name, int position) {
    this.name = name;
    this.playing = false;
    this.won = false;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isPlaying() {
    return playing;
  }

  public void setPlaying(boolean playing) {
    this.playing = playing;
  }

  public boolean isWon() {
    return won;
  }

  public void setWon(boolean won) {
    this.won = won;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return name.equals(player.name);
  }
}
