package it.unicam.cs.pa.FrancescoBonifazi114108;

/**
 * This class specifies a direction and formats it into a lowercase string.
 *
 */
public class Direction {
    private String direction = "";

    /**
     * Constructs a Direction object and formats its string parameter into lowercase letters
     *
     * @param direction UP - DOWN - LEFT - RIGHT directions to get formatted
     */
    public Direction(String direction){

        if(direction.equalsIgnoreCase("up") || direction.equalsIgnoreCase("down") || direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")){
            this.direction = direction.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid direction!");
        }

    }

    /**
     * Returns the direction of this object (lowercase String)
     *
     * @return Direction ("up", "down", "left", "right") formatted in lowercase
     */
    public String getDirection(){
        return direction;
    }
}
