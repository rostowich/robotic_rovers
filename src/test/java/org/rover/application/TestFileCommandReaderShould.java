package org.rover.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.rover.application.read.CommandReader;
import org.rover.application.read.FileCommandReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFileCommandReaderShould {

    @TempDir
    Path tempDir;

    Path tempFile;

    @BeforeEach
    void setup() throws IOException {
        // Create a temporary file.This is guaranteed to be deleted after the test finishes.
        tempFile = Files.createFile(tempDir.resolve("testFile.txt"));
    }

    @Test
    public void return_the_list_of_command_read_from_input_file() throws IOException {
        Files.writeString(tempFile, "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");
        CommandReader reader = new FileCommandReader(tempFile.toString());

        List<String> result = reader.read();
        List<String> expected = Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM");

        assertEquals(result, expected);
    }

}
