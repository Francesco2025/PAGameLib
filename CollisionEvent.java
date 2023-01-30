package it.unicam.cs.pa.FrancescoBonifazi114108;

/**
 * This class describes a CollisionEvent between two Actors
 *
 * It has get methods to return which actor is colliding with another and viceversa
 *
 */
public class CollisionEvent implements Collision{

    Actor[] actors = new Actor[2];

    /**
     * Constructor for a CollisionEvent, takes in two Actors which can't be NULL and stores them.
     *
     * @param colliding The Colliding Actor
     * @param collided The Collided Actor
     */
    public CollisionEvent(Actor colliding, Actor collided){
        if(colliding == null || collided == null){
            throw new IllegalArgumentException("Cannot have NULL as arguments!");
        }
        actors[0] = colliding;
        actors[1] = collided;
    }

    @Override
    public Actor getCollidingActor() {
        return actors[0];
    }

    @Override
    public Actor getCollidedActor() {
        return actors[1];
    }

    @Override
    public Class<? extends Actor> getCollidingActorType() {
        return actors[0].getClass();
    }

    @Override
    public Class<? extends Actor> getCollidedActorType() {
        return actors[1].getClass();
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof CollisionEvent)) return false;

        CollisionEvent event = (CollisionEvent) obj;

        return this.getCollidedActor() == event.getCollidedActor() && this.getCollidedActorType() == event.getCollidedActorType() && this.getCollidingActor() == event.getCollidingActor() && this.getCollidingActorType() == event.getCollidingActorType();
    }


}
