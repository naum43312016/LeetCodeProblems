package naum.asafov.com.SurroundedRegions130;

import java.util.*;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


 */
public class Main {
    //[["O",["O","X","O","O","O"],["X","X","O","X","O"]]
    public static void main(String[] args) {
        char[][] board = {{'O','X','X','O','X'}
        ,{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','X','X','X'},{'X','X','O','X','O'}};

        //new Solution().solve(board);
        for (char[] b : board){
            System.out.println(Arrays.toString(b));
        }
    }
}

class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && board[i][j] != 'V') {
                    List<int[]> surrounded = new ArrayList<>();
                    if(dfs(i, j, board, surrounded)) {
                        for (int[] coordinate : surrounded) {
                            board[coordinate[0]][coordinate[1]] = 'X';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private boolean dfs(int i, int j, char[][] board, List<int[]> surrounded) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] == 'X' || board[i][j] == 'V') {
            return true;
        } else {
            board[i][j] = 'V';
            surrounded.add(new int[]{i, j});
            boolean res = true;
            res &= dfs(i - 1, j, board, surrounded);
            res &= dfs(i + 1, j, board, surrounded);
            res &= dfs(i, j - 1, board, surrounded);
            res &= dfs(i, j + 1, board, surrounded);
            return res;
        }
    }
}