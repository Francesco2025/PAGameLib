package it.unicam.cs.pa.FrancescoBonifazi114108;

/**
 * Describes a board and the basic methods needed to provide it's functions such as
 * -SIZE (set/get)
 * -Storing Actors
 * -Printing
 * 
 *
 */
public interface GameBoard{

    /**
     * Sets the size of the Gameboard
     * @throws IllegalArgumentException if width or height <= 0
     * @param width width of the gameboard (Max X Coordinates)
     * @param height height of the gameboard (Max Y Coordinates)
     */
    void setSize(int width, int height);

    /**
     * Returns the width of the GameBoard
     *
     * @return width of the gameboard
     */
    int getWidth();

    /**
     * Returns the height of the GameBoard
     *
     * @return height of the gameboard
     */
    int getHeight();

    /**
     * Adds an Actor to the board
     *
     * @throws NullPointerException if actor being added is null
     * @throws IllegalArgumentException if actor is being added on an occupied space
     * @param actor Actor to add
     */
    void addActor(Actor actor);

    /**
     * Adds an Array of Actors to the board
     *
     * @param actors Array of actors
     */
    void addActorList(Actor[] actors);

    /**
     * Removes the first instance of an Actor with the same Label on the board
     *
     * @throws NullPointerException if actor being removed is null
     * @param actor Actor to remove
     * @return TRUE if removed else FALSE
     */
    boolean removeActor(Actor actor);

    /**
     * Removes the Actor with the same Label and Position on the board
     *
     * @throws NullPointerException if actor being removed is null
     * @param actor Actor to remove
     * @return TRUE if removed else FALSE
     */
    boolean removeSpecificActor(Actor actor);

    /**
     * Checks if an actor with the same Label is present on the board
     * The position of the actor is NOT checked!
     *
     * @throws NullPointerException if actor being searched is null
     * @param actor Actor to look for
     * @return TRUE if an actor with the same Label is on the board else FALSE
     */
    boolean containsActor(Actor actor);

    /**
     * Checks if an actor with the same Label and Position is present on the board
     *
     * @throws NullPointerException if actor being searched is null
     * @param actor Actor to look for
     * @return TRUE if an actor with the same Label and Position is on the board else FALSE
     */
    boolean containsSpecificActor(Actor actor);

    /**
     * Checks if a cell is occupied by an Actor
     *
     * @throws IllegalArgumentException if cell is out of array index
     * @param x X Coord
     * @param y Y Coord
     * @return TRUE if occupied else FALSE if free
     */
    boolean isCellOccupied(int x, int y);

    /**
     * Gets the actor inside the specified cell and returns it without removing it
     *
     * @param x X Coordinate
     * @param y Y Coordinate
     * @return Actor if occupied, null if empty
     */
    Actor getCellActor(int x, int y);

    /**
     * Prints the current GameBoard and it's contents to the console
     */
    void printBoard();

    /**
     * Clears all Actors from the board
     */
    void clearBoard();
}
