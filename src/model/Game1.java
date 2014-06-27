package model;

import controller.Controller;

/**
 * Created by rudolpha on 27/06/2014.
 */
public class Game1 {
    private boolean machine;
    private Pebble[][] board;
    private PebbleType playerTurn;
    private Controller controller;

    public Game1(){

    }
    public Game1(boolean machine, Controller controller){
        this.controller=controller;
        this.machine=machine;
        createBoard();
        playerTurn=PebbleType.BLACK;
    }

    private void createBoard(){
        for (int i =0 ;i<9;i++){
            for(int j =0; j<9;j++){
                board[i][j]=new Pebble(PebbleType.EMPTY);
            }
        }
    }

    public PebbleType getPlayerTurn(){
        return playerTurn;
    }

    public void play(Coordinates c) throws SuicideMoveException {

        if (notSuicideMove(c)){
            board[c.getI()][c.getJ()]=new Pebble(playerTurn);
            controller.placePebble(c);
            controller.diableButton(c);
        }else throw new SuicideMoveException();

    }

    private boolean notSuicideMove(Coordinates c) {
        if ((board[c.getI()+1][c.getJ()].getPebbleType()!=playerTurn) && (board[c.getI()-1][c.getJ()].getPebbleType()!=playerTurn) &&
                (board[c.getI()][c.getJ()+1].getPebbleType()!=playerTurn) && (board[c.getI()+1][c.getJ()-1].getPebbleType()!=playerTurn)){
            if ((board[c.getI()+1][c.getJ()].getPebbleType()!=PebbleType.EMPTY) && (board[c.getI()-1][c.getJ()].getPebbleType()!=PebbleType.EMPTY) &&
                    (board[c.getI()][c.getJ()+1].getPebbleType()!=PebbleType.EMPTY) && (board[c.getI()+1][c.getJ()-1].getPebbleType()!=PebbleType.EMPTY)){
                return true;
            }
        }
        return false;
    }
}
