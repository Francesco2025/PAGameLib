package it.unicam.cs.pa.FrancescoBonifazi114108;

/**
 * This interface describes any type of Collision between two actors
 *
 */
public interface Collision {

    /**
     * Returns the Actor which has colliding with another.
     *
     * @return Colliding Actor Object.
     */
    Actor getCollidingActor();

    /**
     * Returns the Actor that's being collided with.
     *
     * @return Collided Actor object.
     */
    Actor getCollidedActor();

    /**
     * Returns the type of Actor which has collided with another.
     *
     * @return Colliding Actor Class.
     */
    Class<? extends Actor> getCollidingActorType();

    /**
     * Returns the type of Actor that's being collided with.
     *
     * @return Collided Actor Class.
     */
    Class<? extends Actor> getCollidedActorType();

}
