package org.rover.domain.api;

import org.junit.jupiter.api.Test;
import org.rover.domain.technical.exceptions.OutOfThePlateauException;
import org.rover.domain.services.evaluation.plateau.create.PlateauCreator;
import org.rover.domain.services.evaluation.position.evaluate.PositionEvaluator;
import org.rover.domain.services.evaluation.position.init.PositionInitializer;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPositionProviderShould {

    @Test
    public void return_the_list_of_new_position_after_executing_a_list_of_command() throws OutOfThePlateauException {

        List<String> commands = Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM");

        Position expectedFirstPosition = new Position(1, 3, Orientation.NORTH);
        Position expectedSecondPosition = new Position(5, 1, Orientation.EAST);

        PositionsProvider positionsProvider = new PositionsProviderImpl(
                new PlateauCreator(),
                new PositionInitializer(),
                new PositionEvaluator()
        );

        List<Position> positions = positionsProvider.evaluatePosition(commands);
        assertEquals(positions.get(0), expectedFirstPosition);
        assertEquals(positions.get(1), expectedSecondPosition);
    }
}
