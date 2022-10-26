package org.rover.domain.services.evaluation.position;

import org.junit.jupiter.api.Test;
import org.rover.domain.technical.exceptions.OutOfThePlateauException;
import org.rover.domain.services.evaluation.position.evaluate.MoveMovementEvaluator;
import org.rover.domain.services.evaluation.position.evaluate.MovementEvaluator;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Plateau;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

import static org.junit.jupiter.api.Assertions.*;

public class TestMoveMovementShould {

    @Test
    public void return_the_new_position_in_plateau_after_moving() throws OutOfThePlateauException {

        Position currentPosition = new Position(1,2, Orientation.NORTH);
        Plateau plateau = new Plateau(5,5);
        PositionInPlateau currentPositionInPlateau = new PositionInPlateau(plateau, currentPosition);
        MovementEvaluator moveMovement = new MoveMovementEvaluator();

        int expectedXPosition = 1;
        int expectedYPosition = 3;
        Orientation expectedOrientation = Orientation.NORTH;
        Position result = moveMovement.evaluate(currentPositionInPlateau);

        assertEquals(result.getX(), expectedXPosition);
        assertEquals(result.getY(), expectedYPosition);
        assertEquals(result.getOrientation(), expectedOrientation);

    }

    @Test
    public void throw_outOfPlateauException_when_the_rover_is_moving_out_of_the_plateau() {

        Position currentPosition = new Position(4,5, Orientation.NORTH);
        Plateau plateau = new Plateau(5,5);
        PositionInPlateau currentPositionInPlateau = new PositionInPlateau(plateau, currentPosition);
        MovementEvaluator moveMovement = new MoveMovementEvaluator();

        Exception outOfThePlateauException = assertThrows(OutOfThePlateauException.class,
                () ->  moveMovement.evaluate(currentPositionInPlateau));

        String expectedMessage = "You are out of the plateau";
        String actualMessage = outOfThePlateauException.getMessage();

        assertInstanceOf(OutOfThePlateauException.class, outOfThePlateauException);
        assertEquals(actualMessage, expectedMessage);

    }
}
