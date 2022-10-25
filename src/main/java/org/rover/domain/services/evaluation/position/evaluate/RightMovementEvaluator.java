package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;

public class RightMovementEvaluator implements PositionEvaluator{

    @Override
    public Position evaluate(Position currentPosition) {

        //Only the orientation will change. x and y will remain the same
        Orientation currentOrientation = currentPosition.getOrientation();
        Orientation newOrientation = Orientation.orientationByValue(currentOrientation.getRightOrientation());
        currentPosition.setOrientation(newOrientation);

        return currentPosition;
    }
}
