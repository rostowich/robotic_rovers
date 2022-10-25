package org.rover.domain.services.evaluation.position.evaluate;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

public class PositionEvaluator {
    public Position evaluate(PositionInPlateau currentPositionInPlateau, String command) throws OutOfThePlateauException{

        String[] movements = command.split("");
        Position currentPosition = currentPositionInPlateau.getPosition();
        for (String movement : movements) {
            PositionEvaluationFactory evaluationFactory = new PositionEvaluationFactory();
            currentPosition = evaluationFactory.getPositionEvaluator(movement)
                    .evaluate(currentPositionInPlateau);
        }

        return currentPosition;
    }
}
