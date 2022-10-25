package org.rover.domain.services.evaluation.position.init;

import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;

import java.util.Arrays;
import java.util.List;

public class PositionInitializer {

    public Position init(String command){
        List<String> commandSplit = Arrays.asList(command.split(" "));
        int xPosition = Integer.parseInt(commandSplit.get(0));
        int yPosition = Integer.parseInt(commandSplit.get(1));
        String OrientationValue = commandSplit.get(2);
        Orientation positionOrientation = Orientation.orientationByValue(OrientationValue);
        return new Position(xPosition, yPosition, positionOrientation);
    }
}
