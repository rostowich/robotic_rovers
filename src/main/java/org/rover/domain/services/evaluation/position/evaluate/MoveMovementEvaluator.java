package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Plateau;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

public class MoveMovementEvaluator implements MovementEvaluator {

    @Override
    public Position evaluate(PositionInPlateau currentPositionInPlateau) throws OutOfThePlateauException {

        //The orientation will not change. Only x and y can change
        Position currentPosition = currentPositionInPlateau.getPosition();
        currentPosition.setX(currentPosition.getX() + currentPosition.getOrientation().getXMovement());
        currentPosition.setY(currentPosition.getY() + currentPosition.getOrientation().getYMovement());
        if(isOutOfThePlateau(currentPosition, currentPositionInPlateau.getPlateau())){
            throw new OutOfThePlateauException("You are out of the plateau");
        }
        return currentPosition;
    }

    private boolean isOutOfThePlateau(Position position, Plateau plateau){
        return (position.getX() > plateau.getLength()) || (position.getY() > plateau.getWidth());
    }
}
