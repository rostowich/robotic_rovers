package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Position;

public interface PositionEvaluator {
    Position evaluate(Position currentPosition) throws OutOfThePlateauException;
}
