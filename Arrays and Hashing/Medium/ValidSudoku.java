package Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // Problem Statement
    // You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the
    // following rules are followed:
    // Each row must contain the digits 1-9 without duplicates.
    // Each column must contain the digits 1-9 without duplicates.
    // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
    // without duplicates.
    // Return true if the Sudoku board is valid, otherwise return false
    // Note: A board does not need to be full or be solvable to be valid.

    // Example 1:
    // Input: board =
    // [["1","2",".",".","3",".",".",".","."],
    // ["4",".",".","5",".",".",".",".","."],
    // [".","9","8",".",".",".",".",".","3"],
    // ["5",".",".",".","6",".",".",".","4"],
    // [".",".",".","8",".","3",".",".","5"],
    // ["7",".",".",".","2",".",".",".","6"],
    // [".",".",".",".",".",".","2",".","."],
    // [".",".",".","4","1","9",".",".","8"],
    // [".",".",".",".","8",".",".","7","9"]]

    // Output: true

    // Constraints:
    // board.length == 9
    // board[i].length == 9
    // board[i][j] is a digit 1-9 or '.'.

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = new char[][] {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(validSudoku.isValidSudoku(board)); // true
    }

    // Approach is to use three sets to keep track of the characters in the current
    // row, column and grid
    // we iterate through the board and for each character we check if it is already
    // present in the corresponding set and if it is we return false otherwise we
    // add it to the set
    // :: time complexity O(1) space complexity O(1) since the board is always 9 x 9
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        Set<Character>[] gridSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            gridSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            columnSet.clear();
            for (int j = 0; j < 9; j++) {
                char rowCharacter = board[i][j];
                char columnCharacter = board[j][i];
                // calculating the current character position in the grid set by using the
                // formula (i / 3) * 3 + (j / 3) where i is the current row and j is the current
                // column
                int currentCharPosition = (i / 3) * 3 + (j / 3);
                // if the character is not '.' and it is already present in the corresponding
                // set we return false otherwise we add it to the set
                if (rowCharacter != '.' && !rowSet.add(rowCharacter)) {
                    return false;
                }
                // we check the column character in the column set and the grid character in the
                // grid set and if it is already present we return false otherwise we add it to
                // the set
                if (columnCharacter != '.' && !columnSet.add(columnCharacter)) {
                    return false;
                }
                // we check the grid character in the grid set and if it is already present we
                // return false otherwise we add it to the set
                if (rowCharacter != '.' &&
                        !gridSet[currentCharPosition].add(rowCharacter)) {
                    return false;
                }
            }
        }

        return true;
    }

}
