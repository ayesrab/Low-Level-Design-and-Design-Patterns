package SnakesAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int size, int noOfSnakes, int noOfLadders) {
        initializeCells(size);
        addSnakesAndLadder(noOfSnakes,noOfLadders);
    }
    public void initializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];
        for(int x = 0; x < boardSize; x++){
            for(int y = 0; y < boardSize; y++){
                Cell cell = new Cell();
                cells[x][y] = cell;
            }
        }
    }
    public void addSnakesAndLadder(int noOfSnakes, int noOfLadders){
        while(noOfLadders > 0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(end < start) continue;
            Jump ladderObj = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = ladderObj;
            noOfLadders--;
        }
        while(noOfSnakes > 0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(start < end) continue;
            Jump snakeObj = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = snakeObj;
            noOfSnakes--;
        }
    }
    public Cell getCell(int x){
        int row = x / cells.length;
        int col = x % cells.length;
        return cells[row][col];
    }
}
