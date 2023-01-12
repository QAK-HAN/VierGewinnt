package view;

import controller.Controller;
import processing.core.PApplet;


public class View extends PApplet {

    public static void main(String[] args) {
        PApplet.main(View.class);
    }

    public int width = 800;
    public int height = 700;

    Player currentPlayer = Player.PLAYER_1;
    Controller controller = new Controller();

    public void settings() {
        size(width, height);
    }

    public void setup() {
        background(0);
         controller.initializeGrid();
    }

    private Player invertPlayer(Player player) {
        if (player == Player.PLAYER_1)
            return Player.PLAYER_2;
        else
            return Player.PLAYER_1;
    }

    public void draw() {
        // Draw the board
        clear();

        // Check for a winner
        if (controller.isPlayerWinning(currentPlayer)) {
            textSize(20);
            if (currentPlayer == Player.PLAYER_1) {
                fill(255, 0, 0);
                text("Player 1!", width / 2f, height / 2f);
            } else if (currentPlayer == Player.PLAYER_2) {
                fill(0, 255, 0);
                text("Player 2!", width / 2f, height / 2f);
            }
            textSize(1);
        } else {
            int[][] grid = controller.getGrid();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == Player.PLAYER_1.getId()) {
                        fill(255, 0, 0);
                    } else if (grid[i][j] == Player.PLAYER_2.getId()) {
                        fill(0, 255, 0);
                    } else {
                        fill(255);
                    }
                    circle(j * 100 + 100, i * 100 + 125, 60);
                }
            }

            drawHover();
        }
    }


    public void mouseClicked() {
        if (!controller.isGameOver()) {
            currentPlayer = invertPlayer(currentPlayer);
            int column = (((mouseX - 100) + 30 + 25) / 100);
            //100
            System.out.println(column);
            controller.updateGridField(column, currentPlayer);
        }
    }


    private void drawHover() {
        int column = (((mouseX - 100) + 30 + 25) / 100);
        int xValue = (column * 100) + 100;
        rectMode(CENTER);
        noFill();
        if (invertPlayer(currentPlayer) == Player.PLAYER_1)
            stroke(255, 0, 0);

        else
            stroke(0, 255, 0);

        rect(xValue, 350, 100, 675);
        stroke(0, 0, 0);
        fill(0);
    }
}




