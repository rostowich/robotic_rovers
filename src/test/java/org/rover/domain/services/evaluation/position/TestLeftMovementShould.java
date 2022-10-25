package org.rover.domain.services.evaluation.position;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.evaluation.position.evaluate.LeftMovementEvaluator;
import org.rover.domain.services.evaluation.position.evaluate.MovementEvaluator;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Plateau;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLeftMovementShould {

    static PositionInPlateau initialPositionInPlateau;
    @BeforeAll
    static void setup(){
        Position currentPosition = new Position(1,2, Orientation.NORTH);
        Plateau plateau = new Plateau(5,5);
        initialPositionInPlateau = new PositionInPlateau(currentPosition, plateau);
    }


    @Test
    public void return_the_new_position_in_plateau_after_moving_to_left() throws OutOfThePlateauException {

        MovementEvaluator leftMovement = new LeftMovementEvaluator();

        int expectedXPosition = 1;
        int expectedYPosition = 2;
        Orientation expectedOrientation = Orientation.WEST;
        PositionInPlateau result = leftMovement.evaluateMovement(initialPositionInPlateau);

        assertEquals(result.getCurrentPosition().getX(), expectedXPosition);
        assertEquals(result.getCurrentPosition().getY(), expectedYPosition);
        assertEquals(result.getCurrentPosition().getOrientation(), expectedOrientation);

    }
}
