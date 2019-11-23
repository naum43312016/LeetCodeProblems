package naum.asafov.com.wordsearch79;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class Main {
    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SF";
        boolean a = new Solution().exist(board,word);
        System.out.println(a);
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if ((word.charAt(0) == board[row][col]) && search(board, word, visited, row, col, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean search(char[][] board, String word, boolean[][] visited, int row, int col, int spot) {
        if (spot == word.length()) {
            return true;
        }

        visited[row][col] = true;
        for (int[] d: dir) {
            int x = d[0] + col;
            int y = d[1] + row;

            if (y < 0 || y >= board.length
                    || x < 0 || x >= board[y].length
                    || visited[y][x]
                    || board[y][x] != word.charAt(spot)) {
                continue;
            }
            if (search(board, word, visited, y, x, spot + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}