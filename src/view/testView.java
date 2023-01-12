package view;
import processing.core.PApplet;

public class testView extends PApplet {
    public static void main(String[] args) {
        PApplet.main(View.class);
    }
    public int width = 800;
    public int height = 700;
    int[][] grid = new int[7][6];
    int playerNow = 1;
    int winner = 0;
    public void settings(){
        size(width, height);
    }

    public void setup() {
        background(0);
        //rect(width*0.2f, height*0.2f,0,width, height);
        // Initialize the board with all cells set to 0 (empty)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = 0;
            }
        }


        System.out.print((width*0.2));
        System.out.print((height*0.2));

    }



    public void draw(){
        // Draw the board
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (grid[i][j] == 0) {
                    fill(255);
                } else if (grid[i][j] == 1) {
                    fill(255, 0, 0);
                } else {
                    fill(0, 255, 0);
                }
                circle(i * 100+100, j * 100+125,  60);
            }
        }
        // Check for a winner
        if (winnerCheck()==true) {
            if (winner == 1) {
                fill(255, 0, 0);
                text("Player 1!", width / 2, height / 2);
            } else if (winner == -1) {
                fill(0, 255, 0);
                text("Player 2!", width / 2, height / 2);
            }
        }


    }





    public void mouseClicked() {
        if (winner == 0) {
            int column = (mouseX-100) / 100;
            System.out.println(column);
            if (column >= 0 && column < 7) {
                // Find the first empty cell in the column
                int row = 5;
                while (row >= 0 && grid[column][row] != 0) {
                    row--;
                }
                if (row >= 0) {

                    System.out.println(playerNow);
                    grid[column][row] = playerNow;
                    System.out.println(playerNow);
                    playerNow = -playerNow;
                    System.out.println(playerNow);
                }
            }
        }
    }
    public boolean winnerCheck() {
        // Check for horizontal lines
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == grid[i][j + 1] && grid[i][j + 1] == grid[i][j + 2] && grid[i][j + 2] == grid[i][j + 3] && grid[i][j] != 0) {
                    winner = grid[i][j];
                    return true;
                }
            }
        }
        // Check for vertical lines
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (grid[i][j] == grid[i + 1][j] && grid[i + 1][j] == grid[i + 2][j] && grid[i + 2][j] == grid[i + 3][j] && grid[i][j] != 0) {
                    winner = grid[i][j];
                    return true;
                }
            }
        }
        // Check for diagonal lines
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == grid[i + 1][j + 1] && grid[i + 1][j + 1] == grid[i + 2][j + 2] && grid[i + 2][j + 2] == grid[i + 3][j + 3] && grid[i][j] != 0) {
                    winner = grid[i][j];
                    return true;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 6; j++) {
                if (grid[i][j] == grid[i + 1][j - 1] && grid[i + 1][j - 1] == grid[i + 2][j - 2] && grid[i + 2][j - 2] == grid[i + 3][j - 3] && grid[i][j] != 0) {
                    winner = grid[i][j];
                    return true;
                }
            }
        }
        return false;
    }
}




