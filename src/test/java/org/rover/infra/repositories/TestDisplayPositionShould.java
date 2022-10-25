package org.rover.infra.repositories;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDisplayPositionShould {
    static ByteArrayOutputStream outContent;
    static final PrintStream originalOut = System.out;

    @BeforeAll
    static void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void return_value_provided_to_the_console(){
        DisplayPositionRepository displayPositionRepository = new DisplayPositionRepository();
        displayPositionRepository.show("3,5,N");
        assertEquals("3,5,N", outContent.toString());
    }
}
