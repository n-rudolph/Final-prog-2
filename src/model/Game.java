package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudolpha on 17/05/2014.
 */
public class Game {

    private Pebble[][] board;
    private boolean machine, level;
    private PebbleType playerTurn;
    private int whiteScore, blcakScore, passCount;


    public Game(boolean machine){
        board= new Pebble[9][9];
        whiteScore=blcakScore=passCount=0;
        playerTurn=PebbleType.BLACK;
        this.machine=machine;

        for (int i =0;i<9;i++){
            for (int j =0;j<9; j++){
                board[i][j]= new Pebble(PebbleType.EMPTY);
            }
        }
    }

    public void play(int row, int column){
        if (playerTurn== PebbleType.BLACK) {
            board[row][column]=new Pebble(PebbleType.BLACK);
        }else board[row][column]=new Pebble(PebbleType.WHITE);
    }

    public void eatCheck(int row, int column){
        if (board[row-1][column].pebbleType!=playerTurn){
            check(row - 1, column);
        } else if (board[row+1][column].pebbleType!=playerTurn){
            check(row+1,column);
        }else if (board[row][column-1].pebbleType!=playerTurn){
            check(row,column-1);
        } else if (board[row][column+1].pebbleType!=playerTurn){
            check(row,column+1);
        }
    }

    private void check(int row, int column) {
        if ((board[row+1][column].pebbleType==playerTurn)&&(board[row+1][column].pebbleType==playerTurn)&&
                (board[row+1][column].pebbleType==playerTurn)&&(board[row+1][column].pebbleType==playerTurn)){
            board[row][row]= new Pebble(PebbleType.EMPTY);
        }
    }

}
