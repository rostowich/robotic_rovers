package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

public class MoveMovementEvaluator implements MovementEvaluator{

    @Override
    public PositionInPlateau evaluateMovement(PositionInPlateau currentPositionInPlateau) throws OutOfThePlateauException {

        //The orientation will not change. Only x and y can change
        Position currentPosition = currentPositionInPlateau.getCurrentPosition();
        currentPosition.setX(currentPosition.getX() + currentPosition.getOrientation().getXMovement());
        currentPosition.setY(currentPosition.getY() + currentPosition.getOrientation().getYMovement());

        currentPositionInPlateau.setCurrentPosition(currentPosition);

        return currentPositionInPlateau;
    }
}
