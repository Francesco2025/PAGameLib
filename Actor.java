package it.unicam.cs.pa.FrancescoBonifazi114108;

import java.util.ArrayList;

/**
 * The Actor interface describes any object capable of interacting with the Board.
 *
 * It provides methods for implementing controllable and uncontrollable Actors.
 *
 */
public interface Actor {

    /**
     * Sets the label of the Actor
     * @param label Label of the Actor
     */
    void setLabel(String label);

    /**
     * Returns the label of the Actor
     *
     * @return label of the Actor
     */
    String getLabel();
    /**
     * Returns the X position of the Actor
     *
     * @return X coordinates of the Actor
     */
    int getX();

    /**
     * Returns the Y position of the Actor
     *
     * @return Y coordinates of the Actor
     */
    int getY();

    /**
     * Adds a CollisionEvent to the Actor
     *
     * @throws IllegalArgumentException if the event is NULL
     * @param event Event to add
     */
    void addCollisionEvent(Collision event);

    /**
     * Returns an ArrayList of CollisionEvent objects describing an event where
     * an Actor collides with another actor on the gameboard
     *
     * @return ArrayList of CollisionEvent Objects
     */
    ArrayList<CollisionEvent> getCollisions();

    /**
     * Teleports an Actor to a specific cell on the board. Checks if the actor object is present on the board and if
     * the movement you're trying to accomplish is valid (Not out of bounds or ends up on top of another piece)
     * then updates the board's saved piece position and the piece position itself.
     *
     * @throws IllegalArgumentException If the board doesn't contain this piece
     * @throws IllegalArgumentException If the cell you're moving to is occupied by another piece
     * @param x X Coordinate
     * @param y Y Coordinate
     * @param board Board on which the Actor is present
     */
    void teleport(int x, int y, GameBoard board);

    /**
     * Moves an Actor on the board. Checks if the actor object is present on the board and if
     * the movement you're trying to accomplish is valid (Not out of bounds or ends up on top of another piece)
     * then updates the board's saved piece position and the piece position itself.
     *
     * Unlike void teleport(), it doesn't throw an exception if the movement is invalid.
     * Instead, it returns TRUE or FALSE
     *
     * This method also generates a collisionEvent when moving on an occupied cell.
     *
     * @throws IllegalArgumentException If the board doesn't contain this piece
     * @param distance How much to move the actor
     * @param direction Which direction to move the actor (Up,Down,Left,Right)
     * @param board Board on which the Actor is present
     * @return TRUE if movement was successful else FALSE
     */
    boolean movement(int distance, Direction direction, GameBoard board);

    /**
     * Checks if the movement you're trying to make doesn't go out of bounds.
     *
     * @param distance The distance of your movement
     * @param direction The direction you're trying to move in
     * @param board The board inside which you're moving
     * @return TRUE if valide else FALSE
     */
    boolean isValidMovement(int distance, Direction direction, GameBoard board);

}
