package org.rover.application.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileCommandReader implements CommandReader{
    private final String filePath;

    public FileCommandReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> read() throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
