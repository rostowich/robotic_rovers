package org.rover.domain.api;

import org.rover.domain.technical.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Position;

import java.util.List;

public interface PositionsProvider {
    List<Position> evaluatePosition(List<String> commands) throws OutOfThePlateauException;
}
