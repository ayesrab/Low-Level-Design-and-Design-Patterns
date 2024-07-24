package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;

    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX playingPieceX = new PlayingPieceX(Piece.X);
        Player player1 = new Player(playingPieceX,"Player1");
        players.add(player1);
        PlayingPieceO playingPieceO = new PlayingPieceO(Piece.O);
        Player player2 = new Player(playingPieceO,"Player2");
        players.add(player2);
        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            List<List<Integer>> freeCells = board.freeCells();
            if(freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }
            System.out.println("Player " + currentPlayer.getName() + "Enter the row and column number");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String values [] = input.split(" ");
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);
            if(!board.addPiece(row,column,currentPlayer.getPlayingPiece())){
                System.out.println("Incorrect postition try again");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            boolean winner = isThereWinner(row,column,currentPlayer.getPlayingPiece().piece);
            if(winner){
                return currentPlayer.getName();
            }
        }
        return "Tie";
    }
    public boolean isThereWinner(int row,int col,Piece piece){
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i = 0;i<board.size;i++){
            if (board.board[row][i] == null || board.board[row][i].piece != piece){
                rowMatch = false;
            }
        }
        for(int i = 0;i<board.size;i++){
            if (board.board[i][col] == null || board.board[i][col].piece != piece){
                colMatch = false;
            }
        }
        for(int i = 0,j=0;i<board.size;i++,j++){
            if (board.board[i][j] == null || board.board[i][j].piece != piece){
                diagonalMatch = false;
            }
        }
        for(int i = 0,j= board.size-1;i<board.size;i++,j--){
            if (board.board[i][j] == null || board.board[i][j].piece != piece){
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
