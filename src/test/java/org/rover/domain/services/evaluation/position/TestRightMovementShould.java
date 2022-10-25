package org.rover.domain.services.evaluation.position;

import org.junit.jupiter.api.Test;
import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.evaluation.position.evaluate.PositionEvaluator;
import org.rover.domain.services.evaluation.position.evaluate.RightMovementEvaluator;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRightMovementShould {

    @Test
    public void return_the_new_position_in_plateau_after_moving_to_right() throws OutOfThePlateauException {

        Position currentPosition = new Position(1,2, Orientation.NORTH);
        PositionEvaluator rightMovement = new RightMovementEvaluator();

        int expectedXPosition = 1;
        int expectedYPosition = 2;
        Orientation expectedOrientation = Orientation.EAST;
        Position result = rightMovement.evaluate(currentPosition);

        assertEquals(result.getX(), expectedXPosition);
        assertEquals(result.getY(), expectedYPosition);
        assertEquals(result.getOrientation(), expectedOrientation);

    }
}
