package it.unicam.cs.pa.FrancescoBonifazi114108;

import java.util.Arrays;

/**
 * This class generates a generic board that can be used to build any kind of grid-style games.
 * It's capable of holding Actors of any kind.
 *
 */
public class Board implements GameBoard{

    private Actor[][] board;

    public Board(int width, int height){
        setSize(width, height);
    }
    @Override
    public void setSize(int width, int height) {
        if(width <= 0 || height <= 0){
            throw new IllegalArgumentException("Invalid SIZE");
        }
        board = new Actor[width][height];
    }

    @Override
    public int getWidth() {
        return board.length;
    }

    @Override
    public int getHeight() {
        return board[0].length;
    }

    @Override
    public void addActor(Actor actor) {
        if(actor == null){
            throw new NullPointerException("Cannot add NULL actors");
        }
        if(board[actor.getX()][actor.getY()] != null){
            throw new IllegalArgumentException("Another Actor occupies this space!");
        }
        board[actor.getX()][actor.getY()] = actor;
    }

    @Override
    public void addActorList(Actor[] actors) {
        for (Actor actor : actors) {
            try {
                addActor(actor);
            } catch (Exception e) {
                System.out.println("Failed to add " + actor.toString());
            }
        }
    }

    @Override
    public boolean removeActor(Actor actor) {
        if(actor == null){
            throw new NullPointerException("Cannot remove NULL actors");
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != null && board[i][j].equals(actor)){
                    board[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeSpecificActor(Actor actor) {
        if(actor == null){
            throw new NullPointerException("Cannot remove NULL actors");
        }
        if(board[actor.getX()][actor.getY()] != null && board[actor.getX()][actor.getY()].equals(actor)){
            board[actor.getX()][actor.getY()] = null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsActor(Actor actor){
        if(actor == null){
            throw new NullPointerException("Cannot remove NULL actors");
        }
        for (Actor[] actors : board) {
            for (Actor value : actors) {
                if (value != null && value.equals(actor)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean containsSpecificActor(Actor actor){
        if(actor == null){
            throw new NullPointerException("Cannot remove NULL actors");
        }
        return board[actor.getX()][actor.getY()] != null && board[actor.getX()][actor.getY()].equals(actor);
    }

    @Override
    public boolean isCellOccupied(int x, int y){
        if(x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight()){
            throw new IllegalArgumentException("Invalid Coordinates");
        }
        return board[x][y] != null;
    }

    @Override
    public Actor getCellActor(int x, int y) {
        if(x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight()){
            throw new IllegalArgumentException("Invalid Coordinates");
        }
        return board[x][y];
    }
    @Override
    public void printBoard(){
        for(int i = board.length-1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == null){
                    if(j == board[i].length-1){
                        System.out.println(" |");
                    } else {
                        System.out.print(" |");
                    }
                } else if (j == board[i].length - 1){
                    System.out.print(board[i][j].toString());
                    System.out.println("|");
                } else {
                    System.out.print(board[i][j].toString());
                    System.out.print("|");
                }
            }
        }
        System.out.println();
    }

    @Override
    public void clearBoard() {
        int i = 0;
        while (i < board.length) {
            Arrays.fill(board[i], null);
            i++;
        }
    }
}
