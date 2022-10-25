package org.rover.domain.services.evaluation.position;

import org.junit.jupiter.api.Test;
import org.rover.domain.services.evaluation.position.init.PositionInitializer;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPositionInitializerShould {

    final PositionInitializer initialPosition = new PositionInitializer();
    @Test
    public void return_a_plateau_with_length_and_width(){
        Position result = initialPosition.init("1 2 N");

        int expectedX = 1;
        int expectedY = 2;
        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(result.getX(), expectedX);
        assertEquals(result.getY(), expectedY);
        assertEquals(result.getOrientation(), expectedOrientation);
    }
}
