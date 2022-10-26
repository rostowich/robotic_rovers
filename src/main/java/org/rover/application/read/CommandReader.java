package org.rover.application.read;

import java.io.IOException;
import java.util.List;

public interface CommandReader {

    List<String> read() throws IOException;
}
