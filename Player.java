package it.unicam.cs.pa.FrancescoBonifazi114108;

import java.util.ArrayList;

/**
 * A Player object which implements the Actor interface and uses it's methods to generate a usable player
 *
 * Basic methods to get and set the label, move, teleport, and store collisions.
 *
 */
public class Player implements Actor{

    private String label;
    private int x, y;

    private ArrayList<CollisionEvent> collisions = new ArrayList<>();

    public Player(int x, int y, String label){
        if(label == null){
            throw new IllegalArgumentException("Label cannot be NULL!");
        }
        this.x = x;
        this.y = y;
        setLabel(label);
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void addCollisionEvent(Collision event){
        if(event == null){
            throw new IllegalArgumentException("Collision Event can't be NULL!");
        }
        collisions.add((CollisionEvent) event);
    }


    @Override
    public ArrayList<CollisionEvent> getCollisions(){
        return collisions;
    }

    @Override
    public void teleport(int x, int y, GameBoard board) {
        if(!board.containsSpecificActor(this)){
            throw new IllegalArgumentException("Player not present in this board");
        }
        if(board.isCellOccupied(x,y)){
            throw new IllegalArgumentException("Cannot teleport to occupied cell!");
        }
        board.removeSpecificActor(this);
        this.x = x;
        this.y = y;
        board.addActor(this);

    }

    @Override
    public boolean movement(int distance, Direction direction, GameBoard board) {
        if(!board.containsSpecificActor(this)){
            throw new IllegalArgumentException("Player not present in this board");
        }
        return moveActor(distance,direction,board);
    }

    @Override
    public boolean isValidMovement(int distance, Direction direction, GameBoard board){
        return switch (direction.getDirection()) {
            case "up" -> this.x + distance < board.getHeight();
            case "down" -> this.x - distance >= 0;
            case "left" -> this.y - distance >= 0;
            case "right" -> this.y + distance < board.getWidth();
            default -> false;
        };
    }

    private boolean moveActor(int distance, Direction direction, GameBoard board){
        switch (direction.getDirection()){

            case "up":
                if(!isValidMovement(distance, direction, board)){
                    return false;
                }
                if(board.isCellOccupied(x+distance, y)){
                    addCollisionEvent(new CollisionEvent(this, board.getCellActor(x+distance, y)));
                    return false;
                } else {
                    board.removeSpecificActor(this);
                    this.x += distance;
                    board.addActor(this);
                    return true;
                }

            case "down":
                if(!isValidMovement(distance,direction,board)) {
                    return false;
                }
                if( board.isCellOccupied(x-distance, y)){
                    addCollisionEvent(new CollisionEvent(this, board.getCellActor(x-distance, y)));
                    return false;
                } else {
                    board.removeSpecificActor(this);
                    this.x -= distance;
                    board.addActor(this);
                    return true;
                }

            case "left":
                if(!isValidMovement(distance,direction,board)){
                 return false;
                }
                if(board.isCellOccupied(x, y-distance)){
                    addCollisionEvent(new CollisionEvent(this, board.getCellActor(x, y-distance)));
                    return false;
                } else {
                    board.removeSpecificActor(this);
                    this.y -= distance;
                    board.addActor(this);
                    return true;
                }

            case "right":
                if(!isValidMovement(distance,direction,board)) {
                    return false;
                }
                if(board.isCellOccupied(x, y+distance)){
                    addCollisionEvent(new CollisionEvent(this, board.getCellActor(x, y+distance)));
                    return false;
                } else {
                    board.removeSpecificActor(this);
                    this.y += distance;
                    board.addActor(this);
                    return true;
                }

            default:
                return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Player)) return false;

        Player p = (Player) obj;

        return this.label.equals(p.getLabel());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.label != null ? this.label.hashCode() : 0);

        return hash;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
