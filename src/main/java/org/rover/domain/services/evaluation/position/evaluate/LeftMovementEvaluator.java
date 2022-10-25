package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.PositionInPlateau;

public class LeftMovementEvaluator implements MovementEvaluator{

    @Override
    public PositionInPlateau evaluateMovement(PositionInPlateau currentPositionInPlateau) throws OutOfThePlateauException {

        //Only the orientation will change. x and y will remain the same
        Orientation currentOrientation = currentPositionInPlateau.getCurrentPosition().getOrientation();
        Orientation newOrientation = Orientation.orientationByValue(currentOrientation.getLeftOrientation());
        currentPositionInPlateau.getCurrentPosition().setOrientation(newOrientation);

        return currentPositionInPlateau;
    }
}
