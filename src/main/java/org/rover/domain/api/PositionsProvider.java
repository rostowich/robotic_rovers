package org.rover.domain.api;

import java.util.List;

public interface PositionsProvider {

    String evaluatePosition(List<String> commands);
}
