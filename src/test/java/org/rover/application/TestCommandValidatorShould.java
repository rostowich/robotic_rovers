package org.rover.application;

import org.junit.jupiter.api.Test;
import org.rover.application.validate.CommandValidator;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommandValidatorShould {

    @Test
    public void return_true_response_because_the_command_is_valid(){
        List<String> commands = Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM");

        CommandValidator commandValidator = new CommandValidator();
        boolean result = commandValidator.validate(commands);
        boolean expected = true;

        assertEquals(result, expected);
    }

    @Test
    public void return_false_response_because_the_command_is_not_valid(){
        List<String> commands = Arrays.asList("5 5", "1 2 N", "LMLMLMLMMD", "3 3 E", "MMRMMRMRRM");

        CommandValidator commandValidator = new CommandValidator();
        boolean result = commandValidator.validate(commands);
        boolean expected = false;

        assertEquals(result, expected);
    }
}
