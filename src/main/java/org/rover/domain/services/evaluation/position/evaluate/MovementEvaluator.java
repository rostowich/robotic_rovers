package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

public interface MovementEvaluator {
    Position evaluate(PositionInPlateau currentPosition) throws OutOfThePlateauException;
}
