package org.rover.domain.services.evaluation.position;

import org.junit.jupiter.api.Test;
import org.rover.domain.technical.exceptions.OutOfThePlateauException;
import org.rover.domain.services.evaluation.position.evaluate.PositionEvaluator;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Plateau;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPositionEvaluatorShould {

    @Test
    public void return_the_new_position_in_plateau_after_a_sequence_of_movement() throws OutOfThePlateauException {

        Position currentPosition = new Position(1,2, Orientation.NORTH);
        Plateau plateau = new Plateau(5,5);
        PositionInPlateau currentPositionInPlateau = new PositionInPlateau(plateau, currentPosition);
        PositionEvaluator positionEvaluator = new PositionEvaluator();
        int expectedXPosition = 1;
        int expectedYPosition = 3;
        Orientation expectedOrientation = Orientation.NORTH;
        Position result = positionEvaluator.evaluate(currentPositionInPlateau, "LMLMLMLMM");

        assertEquals(result.getX(), expectedXPosition);
        assertEquals(result.getY(), expectedYPosition);
        assertEquals(result.getOrientation(), expectedOrientation);

    }
}
