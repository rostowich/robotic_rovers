package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Plateau;
import org.rover.domain.services.referentials.Position;

public class MoveMovementEvaluator implements PositionEvaluator{

    private final Plateau plateau;

    public MoveMovementEvaluator(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Position evaluate(Position currentPosition) throws OutOfThePlateauException {

        //The orientation will not change. Only x and y can change
        currentPosition.setX(currentPosition.getX() + currentPosition.getOrientation().getXMovement());
        currentPosition.setY(currentPosition.getY() + currentPosition.getOrientation().getYMovement());
        if(isOutOfThePlateau(currentPosition, plateau)){
            throw new OutOfThePlateauException("You are out of the plateau");
        }
        return currentPosition;
    }

    private boolean isOutOfThePlateau(Position position, Plateau plateau){
        return (position.getX() > plateau.getLength()) || (position.getY() > plateau.getWidth());
    }
}
