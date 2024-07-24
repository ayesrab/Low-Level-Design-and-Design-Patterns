package TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    int size;
    PlayingPiece [][] board;
    Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }
    public boolean addPiece(int row, int col, PlayingPiece piece) {
        if(board[row][col] != null){
            return false;
        }
        board[row][col] = piece;
        return true;
    }
    public List<List<Integer>> freeCells(){
        List<List<Integer>> freeCells = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == null){
                    List<Integer> rowCol = new ArrayList<>();
                    rowCol.add(i);
                    rowCol.add(j);
                    freeCells.add(rowCol);
                }
            }
        }
        return freeCells;
    }
    public void printBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != null){
                    System.out.print(board[i][j].piece.name() + " ");
                }
                else
                    System.out.print("  ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
