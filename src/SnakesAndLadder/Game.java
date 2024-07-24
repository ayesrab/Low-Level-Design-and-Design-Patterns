package SnakesAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Deque<Player> players;
    Dice dice;
    Player winner;

    public Game() {
        initializeGame();
    }
    public void initializeGame(){
        players = new LinkedList<>();
        board = new Board(10,2,2);
        dice = new Dice(3);
        Player player1 = new Player(0,"Player1");
        Player player2 = new Player(0,"Player2");
        players.add(player1);
        players.add(player2);

    }
    public void startGame(){
        while(winner == null){
            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.name + " current position is: " + playerTurn.currentPosition);
            //roll the dice
            int diceNumbers = dice.rollDice();
            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;
            System.out.println("player turn is:" + playerTurn.name + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1){

                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS:" + winner.name);
    }
    public Player findPlayerTurn(){
        Player currentPlayer = players.removeFirst();
        players.addLast(currentPlayer);
        return currentPlayer;
    }
    public int jumpCheck(int playerNewPosition){
        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }
        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition){
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
