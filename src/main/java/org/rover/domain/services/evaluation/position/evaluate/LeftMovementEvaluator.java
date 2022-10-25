package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

public class LeftMovementEvaluator implements MovementEvaluator {

    @Override
    public Position evaluate(PositionInPlateau currentPosition) {

        //Only the orientation will change. x and y will remain the same
        Orientation currentOrientation = currentPosition.getPosition().getOrientation();
        Orientation newOrientation = Orientation.orientationByValue(currentOrientation.getLeftOrientation());
        currentPosition.getPosition().setOrientation(newOrientation);

        return currentPosition.getPosition();
    }
}
