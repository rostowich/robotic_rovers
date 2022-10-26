package org.rover.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rover.application.evaluate.RoverController;
import org.rover.application.read.CommandReader;
import org.rover.application.technical.exceptions.InvalidCommandException;
import org.rover.application.validate.CommandValidator;
import org.rover.application.write.PositionWriter;
import org.rover.domain.api.PositionsProvider;
import org.rover.domain.services.referentials.Orientation;
import org.rover.domain.services.referentials.Position;
import org.rover.domain.technical.exceptions.OutOfThePlateauException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestRoverControllerShould {

    @Mock
    CommandReader commandReader;
    @Mock
    CommandValidator commandValidator;
    @Mock
    PositionsProvider positionsProvider;

    @Mock
    PositionWriter positionWriter;
    private RoverController roverController;

    List<String> commands;

    List<Position> positions;

    @BeforeEach
    public void initialize(){
        commands = Arrays.asList("5 5", "1 2 C", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM");
        positions = Arrays.asList(new Position(1, 3, Orientation.NORTH),
                new Position(5, 1, Orientation.EAST));
        roverController = new RoverController(commandReader, commandValidator, positionsProvider, positionWriter);
    }

    @Test
    public void throw_invalid_command_exception_as_the_command_are_invalid() throws Exception {
        given(commandReader.read()).willReturn(commands);
        given(commandValidator.validate(commands)).willReturn(false);

        Exception invalidCommandException = assertThrows(InvalidCommandException.class,
                () ->  roverController.evaluateCommand());

        String expectedMessage = "Commands are not valid";
        String actualMessage = invalidCommandException.getMessage();

        assertInstanceOf(InvalidCommandException.class, invalidCommandException);
        assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void throw_out_of_plateau_command_exception_as_the_command_are_invalid() throws Exception {
        given(commandReader.read()).willReturn(commands);
        given(commandValidator.validate(commands)).willReturn(true);
        given(positionsProvider.evaluatePosition(commands)).willThrow(new OutOfThePlateauException("The rover is out of the plateau"));

        Exception outOfThePlateauException = assertThrows(OutOfThePlateauException.class,
                () ->  roverController.evaluateCommand());

        String expectedMessage = "The rover is out of the plateau";
        String actualMessage = outOfThePlateauException.getMessage();

        assertInstanceOf(OutOfThePlateauException.class, outOfThePlateauException);
        assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void evaluate_command_as_the_command_are_invalid() throws Exception {
        given(commandReader.read()).willReturn(commands);
        given(commandValidator.validate(commands)).willReturn(true);
        given(positionsProvider.evaluatePosition(commands)).willReturn(positions);
        doNothing().when(positionWriter).display(positions);

        roverController.evaluateCommand();

        verify(commandReader, times(1)).read();
        verify(commandValidator, times(1)).validate(commands);
        verify(positionsProvider, times(1)).evaluatePosition(commands);
        verify(positionWriter, times(1)).display(positions);

    }
}
