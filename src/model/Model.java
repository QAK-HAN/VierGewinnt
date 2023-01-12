package model;

import view.Player;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Model {
    private int[][] grid = new int[6][7];

    public int[][] getGrid() {
        return Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
    }

    public void initializeGrid() {
        grid = IntStream.range(0, grid.length)
                .mapToObj(i -> IntStream.range(0, grid[0].length)
                        .map(x -> x = 0)
                        .toArray())
                .toArray(int[][]::new);
    }

    public boolean isWinning(Player player) {
        return isWinningHorizontally(player) || isWinningVertically(player) || isWinningDiagonally(player);
}

    private boolean isWinningDiagonally(Player player) {
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[0].length -3; j++) {
                if (grid[i][j] == grid[i + 1][j + 1] && grid[i + 1][j + 1] == grid[i + 2][j + 2] && grid[i + 2][j + 2] == grid[i + 3][j + 3] && grid[i][j] == player.getId()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 3; j < grid[0].length; j++) {
                if (grid[i][j] == grid[i + 1][j - 1] && grid[i + 1][j - 1] == grid[i + 2][j - 2] && grid[i + 2][j - 2] == grid[i + 3][j - 3] && grid[i][j] == player.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningVertically(Player player) {
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == grid[i + 1][j] && grid[i + 1][j] == grid[i + 2][j] && grid[i + 2][j] == grid[i + 3][j] && grid[i][j] == player.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningHorizontally(Player player) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length - 3; j++) {
                if (ints[j] == ints[j + 1] && ints[j + 1] == ints[j + 2] && ints[j + 2] == ints[j + 3] && ints[j] == player.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateGridField(int column, Player currentPlayer) {
        for(int row = grid.length - 1; row >= 0; row--)
            if(grid[row][column] == Player.PLAYER_NONE.getId()) {
                grid[row][column] = currentPlayer.getId();
                break;
            }
    }
}
