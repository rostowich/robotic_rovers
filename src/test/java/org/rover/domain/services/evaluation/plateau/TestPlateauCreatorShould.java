package org.rover.domain.services.evaluation.plateau;

import org.junit.jupiter.api.Test;
import org.rover.domain.services.evaluation.plateau.create.PlateauCreator;
import org.rover.domain.services.referentials.Plateau;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlateauCreatorShould {

    final PlateauCreator plateauCreator = new PlateauCreator();
    @Test
    public void return_a_plateau_with_length_and_width(){
        Plateau result = plateauCreator.init("5 5");

        int expectedLength = 5;
        int expectedWidth = 5;

        assertEquals(result.getLength(), expectedLength);
        assertEquals(result.getWidth(), expectedWidth);
    }
}
