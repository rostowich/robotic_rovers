package org.rover.domain.services.evaluation.position.init;

import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;

public class PositionInitializer {

    public Position init(int x, int y, Orientation orientation){
        return new Position(x, y, orientation);
    }
}
