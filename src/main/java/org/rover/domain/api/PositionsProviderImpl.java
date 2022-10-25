package org.rover.domain.api;

import org.rover.domain.services.evaluation.exceptions.OutOfThePlateauException;
import org.rover.domain.services.evaluation.plateau.create.PlateauCreator;
import org.rover.domain.services.evaluation.position.evaluate.PositionEvaluator;
import org.rover.domain.services.evaluation.position.init.PositionInitializer;
import org.rover.domain.services.referentials.Plateau;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.services.referentials.PositionInPlateau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PositionsProviderImpl implements PositionsProvider{

    private final PlateauCreator plateauCreator;
    private final PositionInitializer positionInitializer;
    private final PositionEvaluator positionEvaluator;

    public PositionsProviderImpl(PlateauCreator plateauCreator, PositionInitializer positionInitializer, PositionEvaluator positionEvaluator) {
        this.plateauCreator = plateauCreator;
        this.positionInitializer = positionInitializer;
        this.positionEvaluator = positionEvaluator;
    }

    @Override
    public List<Position> evaluatePosition(List<String> commands) throws OutOfThePlateauException {
        Iterator<String> iterator = commands.iterator();
        List<Position> positions = new ArrayList<>();

        String commandForCreatingPlateau = iterator.next();
        Plateau initialPlateau = plateauCreator.init(commandForCreatingPlateau);

        while (iterator.hasNext()){
            String intPositionCommand = iterator.next();
            Position currentPosition = positionInitializer.init(intPositionCommand);
            PositionInPlateau positionInPlateau = new PositionInPlateau(initialPlateau, currentPosition);
            String command = iterator.next();
            Position finalPosition = positionEvaluator.evaluate(positionInPlateau, command);
            positions.add(finalPosition);
        }

        return positions;
    }
}
