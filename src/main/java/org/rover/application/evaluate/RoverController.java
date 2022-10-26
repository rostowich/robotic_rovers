package org.rover.application.evaluate;

import org.rover.application.read.CommandReader;
import org.rover.application.technical.exceptions.InvalidCommandException;
import org.rover.application.validate.CommandValidator;
import org.rover.application.write.PositionWriter;
import org.rover.domain.api.PositionsProvider;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.technical.exceptions.OutOfThePlateauException;

import java.io.IOException;
import java.util.List;

public class RoverController {
    private final CommandReader commandReader;
    private final CommandValidator commandValidator;
    private final PositionsProvider positionsProvider;
    private final PositionWriter positionWriter;

    public RoverController(CommandReader commandReader, CommandValidator commandValidator, PositionsProvider positionsProvider, PositionWriter positionWriter) {
        this.commandReader = commandReader;
        this.commandValidator = commandValidator;
        this.positionsProvider = positionsProvider;
        this.positionWriter = positionWriter;
    }

    public void evaluateCommand() throws IOException, OutOfThePlateauException, InvalidCommandException {
        List<String> commands = commandReader.read();
        boolean isValid = commandValidator.validate(commands);
        if(!isValid){
            throw new InvalidCommandException("Commands are not valid");
        }
        List<Position> positions = positionsProvider.evaluatePosition(commands);
        positionWriter.display(positions);
    }
}
