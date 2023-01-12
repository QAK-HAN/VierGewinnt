package controller;

import model.Model;
import view.Player;

public class Controller {

 Model model = new Model();




 public boolean isPlayerWinning(Player player) {
   return model.isWinning(player);
 }

 public boolean isGameOver() {
   return model.isWinning(Player.PLAYER_1) || model.isWinning(Player.PLAYER_2);
 }

 public int[][] getGrid() {
  return model.getGrid();
 }

 public void initializeGrid() {
  model.initializeGrid();
 }

 public void updateGridField(int column, Player currentPlayer) {
  model.updateGridField(column, currentPlayer);
 }
}
